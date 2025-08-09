package com.project.lay_note_was.lay_note.service.implement;

import com.project.lay_note_was.lay_note.common.constant.ResponseMessage;
import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.auth.request.LoginRequestDto;
import com.project.lay_note_was.lay_note.dto.auth.request.SignUpRequestDto;
import com.project.lay_note_was.lay_note.dto.auth.response.LoginResponseDto;
import com.project.lay_note_was.lay_note.dto.auth.response.SignUpResponseDto;
import com.project.lay_note_was.lay_note.entity.user.User;
import com.project.lay_note_was.lay_note.provider.JwtProvider;
import com.project.lay_note_was.lay_note.repository.UserRepository;
import com.project.lay_note_was.lay_note.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public ResponseDto<SignUpResponseDto> signUp(SignUpRequestDto dto) {
        String userEmail = dto.getUserEmail();
        String userName = dto.getUserName();
        String nickName = dto.getNickName();
        String userPhone = dto.getUserPhone();
        String password = dto.getPassword();
        String confirmPassword = dto.getConfirmPassword();
        String profileImageUrl = dto.getProfileImageUrl();

        if (!userEmail.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            return ResponseDto.setFailed(ResponseMessage.VALIDATION_FAIL + "userEmail");
        }

        if (!userName.matches("^[A-Za-z가-힣]{2,16}$")) {
            return ResponseDto.setFailed(ResponseMessage.VALIDATION_FAIL + "userEmail");
        }

        if (!nickName.matches("^[A-Za-z가-힣0-9._]{2,14}$")) {
            return ResponseDto.setFailed(ResponseMessage.VALIDATION_FAIL + "userEmail");
        }

        if (!userPhone.matches("010\\d{8}$")) {
            return ResponseDto.setFailed(ResponseMessage.VALIDATION_FAIL + "userEmail");
        }

        if (!password.matches("^(?=.[A-Z])(?=.[a-z])(?=.\\d)(?=.[!@#$%^&*(),.?\":{}|<>]).{8,16}$")) {
            return ResponseDto.setFailed(ResponseMessage.VALIDATION_FAIL + "userEmail");
        }

        if (!password.equals(confirmPassword)) {
            return ResponseDto.setFailed(ResponseMessage.NOT_MATCH_PASSWORD );
        }

        if (userRepository.existsByUserEmail(userEmail)) {
            return ResponseDto.setFailed(ResponseMessage.DUPLICATED_USER_EMAIL);
        }

        if (userRepository.existsByNickName(nickName)) {
            return ResponseDto.setFailed(ResponseMessage.DUPLICATED_NICKNAME);
        }

        try {
            String encodePassword = bCryptPasswordEncoder.encode(password);
            User user = User.builder()
                    .userEmail(userEmail)
                    .password(encodePassword)
                    .nickName(nickName)
                    .userName(userName)
                    .userPhone(userPhone)
                    .profileImageUrl(profileImageUrl)
                    .build();
            userRepository.save(user);
            SignUpResponseDto data = new SignUpResponseDto(user);
            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

    }

    @Override
    public ResponseDto<LoginResponseDto> login(LoginRequestDto dto) {
        String userEmail = dto.getUserEmail();
        String password = dto.getPassword();

        try {
           User user = userRepository.findUser(userEmail);
            if (user == null) {
                return ResponseDto.setFailed(ResponseMessage.EXIST_DATA);
            }
            if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return ResponseDto.setFailed((ResponseMessage.NOT_MATCH_PASSWORD));
            }

            String token = jwtProvider.generateJwtToken(userEmail);
            int exprTime = jwtProvider.getExpiration();

            LoginResponseDto data = new LoginResponseDto(user, token, exprTime);
            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (Exception e) {
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<Boolean> duplicationUserEmail(String userEmail) {
        try {
            boolean result = userRepository.existsByUserEmail(userEmail);
            if (result) {
                return ResponseDto.setSuccess(ResponseMessage.DUPLICATED_USER_EMAIL, true);
            } else {
                return ResponseDto.setSuccess(ResponseMessage.SUCCESS, false);
            }
        } catch (Exception e) {
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<Boolean> duplicationNickName(String nickName) {
        try {
            boolean result = userRepository.existsByNickName(nickName);
            if (result) {
                return ResponseDto.setSuccess(ResponseMessage.DUPLICATED_NICKNAME, true);
            } else {
                return ResponseDto.setSuccess(ResponseMessage.SUCCESS, false);
            }
        } catch (Exception e) {
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }
}

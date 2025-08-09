package com.project.lay_note_was.lay_note.controller;

import com.project.lay_note_was.lay_note.common.constant.ApiMappingPattern;
import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.auth.request.LoginRequestDto;
import com.project.lay_note_was.lay_note.dto.auth.request.SignUpRequestDto;
import com.project.lay_note_was.lay_note.dto.auth.response.LoginResponseDto;
import com.project.lay_note_was.lay_note.dto.auth.response.SignUpResponseDto;
import com.project.lay_note_was.lay_note.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiMappingPattern.AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    private final String LOGIN = "/login";
    private final String SIGN_UP = "/sign-up";
    private final String DUPLICATE_USER_EMAIL = "/duplicate/{userEmail}";
    private final String DUPLICATE_USER_NICKNAME = "/duplication/{nickName}";

    @PostMapping(SIGN_UP)
    public ResponseEntity<ResponseDto<SignUpResponseDto>> signUp (@Valid @RequestBody SignUpRequestDto dto) {
        ResponseDto<SignUpResponseDto> response = authService.signUp(dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @PostMapping(LOGIN)
    public ResponseEntity<ResponseDto<LoginResponseDto>> login (@Valid @RequestBody LoginRequestDto dto) {
        ResponseDto<LoginResponseDto> response = authService.login(dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping(DUPLICATE_USER_EMAIL)
    public ResponseEntity<ResponseDto<Boolean>> duplicationUserEmail (@PathVariable String userEmail) {
        ResponseDto<Boolean> response = authService.duplicationUserEmail(userEmail);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping(DUPLICATE_USER_NICKNAME)
    public ResponseEntity<ResponseDto<Boolean>> duplicationNickName (@PathVariable String nickName) {
        ResponseDto<Boolean> response = authService.duplicationNickName(nickName);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }
}

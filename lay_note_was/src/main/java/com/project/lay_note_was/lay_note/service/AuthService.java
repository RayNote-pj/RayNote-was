package com.project.lay_note_was.lay_note.service;

import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.auth.request.LoginRequestDto;
import com.project.lay_note_was.lay_note.dto.auth.request.SignUpRequestDto;
import com.project.lay_note_was.lay_note.dto.auth.response.LoginResponseDto;
import com.project.lay_note_was.lay_note.dto.auth.response.SignUpResponseDto;
import jakarta.validation.Valid;

public interface AuthService {
    ResponseDto<SignUpResponseDto> signUp(@Valid SignUpRequestDto dto);

    ResponseDto<LoginResponseDto> login(@Valid LoginRequestDto dto);

    ResponseDto<Boolean> duplicationUserEmail(String userEmail);

    ResponseDto<Boolean> duplicationNickName(String nickName);
}

package com.project.lay_note_was.lay_note.service;

import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.user.request.UserDeleteRequestDto;
import com.project.lay_note_was.lay_note.dto.user.request.UserUpdateRequestDto;
import com.project.lay_note_was.lay_note.dto.user.response.UserResponseDto;

public interface UserService {
    ResponseDto<UserResponseDto> getMyAccount(String userEmail);

    ResponseDto<UserResponseDto> updateMyAccount(String userEmail, UserUpdateRequestDto dto);

    ResponseDto<Void> deleteUser(String userEmail, UserDeleteRequestDto dto);
}

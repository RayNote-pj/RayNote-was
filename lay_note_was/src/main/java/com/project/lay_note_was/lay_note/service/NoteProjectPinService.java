package com.project.lay_note_was.lay_note.service;

import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_pin.response.PinListResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_pin.response.PinResponseDto;

public interface NoteProjectPinService {
    ResponseDto<PinListResponseDto> getPinAll(String userEmail);

    ResponseDto<PinResponseDto> createPin(String userEmail, String noteProjectId);

    ResponseDto<Void> deletePin(String userEmail, String pinId);
}

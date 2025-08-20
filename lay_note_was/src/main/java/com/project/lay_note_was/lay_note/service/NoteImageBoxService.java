package com.project.lay_note_was.lay_note.service;

import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_image_box.request.NoteImageBoxRequestDto;
import com.project.lay_note_was.lay_note.dto.note_image_box.response.NoteImageBoxListResponseDto;
import com.project.lay_note_was.lay_note.dto.note_image_box.response.NoteImageBoxResponseDto;

public interface NoteImageBoxService {
    ResponseDto<NoteImageBoxResponseDto> createImageBox(String userEmail, String noteProjectId, Long noteImageBoxListId, NoteImageBoxRequestDto dto);

    ResponseDto<NoteImageBoxResponseDto> updateImageBox(String userEmail, String noteProjectId, Long noteImageBoxListId, Long noteImageBoxId, NoteImageBoxRequestDto dto);

    ResponseDto<Void> deleteImageBox(String userEmail, String noteProjectId, Long noteImageBoxId);
}

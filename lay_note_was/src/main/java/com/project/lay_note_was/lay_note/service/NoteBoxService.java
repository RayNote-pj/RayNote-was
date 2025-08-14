package com.project.lay_note_was.lay_note.service;

import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_box.request.NoteBoxCreateRequestDto;
import com.project.lay_note_was.lay_note.dto.note_box.request.NoteBoxUpdateRequestDto;
import com.project.lay_note_was.lay_note.dto.note_box.response.NoteBoxListResponseDto;
import com.project.lay_note_was.lay_note.dto.note_box.response.NoteBoxResponseDto;

public interface NoteBoxService {
    ResponseDto<NoteBoxResponseDto> createNoteBox(String userEmail, NoteBoxCreateRequestDto dto);

    ResponseDto<NoteBoxResponseDto> updateNoteBox(String userEmail, NoteBoxUpdateRequestDto dto, Long noteBoxId);

    ResponseDto<NoteBoxListResponseDto> getNoteBox(String userEmail);

    ResponseDto<Void> deleteNoteBox(String userEmail, Long noteBoxId);
}

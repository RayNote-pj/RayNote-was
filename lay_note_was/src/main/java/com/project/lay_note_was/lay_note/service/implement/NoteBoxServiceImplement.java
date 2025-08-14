package com.project.lay_note_was.lay_note.service.implement;

import com.project.lay_note_was.lay_note.common.constant.ResponseMessage;
import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_box.request.NoteBoxCreateRequestDto;
import com.project.lay_note_was.lay_note.dto.note_box.request.NoteBoxUpdateRequestDto;
import com.project.lay_note_was.lay_note.dto.note_box.response.NoteBoxListResponseDto;
import com.project.lay_note_was.lay_note.dto.note_box.response.NoteBoxResponseDto;
import com.project.lay_note_was.lay_note.repository.NoteBoxRepository;
import com.project.lay_note_was.lay_note.service.NoteBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteBoxServiceImplement implements NoteBoxService {

    private final NoteBoxRepository noteBoxRepository;

    @Override
    public ResponseDto<NoteBoxResponseDto> createNoteBox(String userEmail, NoteBoxCreateRequestDto dto) {
        try {

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<NoteBoxResponseDto> updateNoteBox(String userEmail, NoteBoxUpdateRequestDto dto, Long noteBoxId) {
        try {

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<NoteBoxListResponseDto> getNoteBox(String userEmail) {
        try {

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<Void> deleteNoteBox(String userEmail, Long noteBoxId) {
        try {

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }
}

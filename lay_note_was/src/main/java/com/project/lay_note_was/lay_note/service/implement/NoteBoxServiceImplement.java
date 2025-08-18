package com.project.lay_note_was.lay_note.service.implement;

import com.project.lay_note_was.lay_note.common.constant.ResponseMessage;
import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_box.NoteBoxDto;
import com.project.lay_note_was.lay_note.dto.note_box.request.NoteBoxCreateRequestDto;
import com.project.lay_note_was.lay_note.dto.note_box.request.NoteBoxUpdateRequestDto;
import com.project.lay_note_was.lay_note.dto.note_box.response.NoteBoxListResponseDto;
import com.project.lay_note_was.lay_note.dto.note_box.response.NoteBoxResponseDto;
import com.project.lay_note_was.lay_note.entity.note_box.NoteBox;
import com.project.lay_note_was.lay_note.repository.NoteBoxRepository;
import com.project.lay_note_was.lay_note.service.NoteBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteBoxServiceImplement implements NoteBoxService {

    private final NoteBoxRepository noteBoxRepository;

    @Override
    public ResponseDto<NoteBoxResponseDto> createNoteBox(String userEmail, NoteBoxCreateRequestDto dto) {
        try {
            NoteBox noteBox = NoteBox.builder()
                    .noteBoxTitle(dto.getNoteBoxTitle())
                    .noteBoxContent(dto.getNoteBoxContent())
                    .imageUrl(dto.getImageUrl())
                    .build();
            noteBoxRepository.save(noteBox);
            NoteBoxDto response = new NoteBoxDto(noteBox);
            NoteBoxResponseDto data = new NoteBoxResponseDto(response);

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<NoteBoxResponseDto> updateNoteBox(String userEmail, NoteBoxUpdateRequestDto dto, Long noteBoxId) {
        try {
            NoteBox noteBox = noteBoxRepository.findById(noteBoxId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_DATA + "noteBox"));

            noteBox.setNoteBoxTitle(dto.getNoteBoxTitle());
            noteBox.setNoteBoxContent(dto.getNoteBoxContent());
            noteBox.setImageUrl(dto.getImageUrl());

            noteBoxRepository.save(noteBox);
            NoteBoxDto response = new NoteBoxDto(noteBox);
            NoteBoxResponseDto data = new NoteBoxResponseDto(response);

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<NoteBoxListResponseDto> getNoteBox(String userEmail) {
        try {
            List<NoteBox> noteBoxes = noteBoxRepository.findAll();

            List<NoteBoxDto> response = noteBoxes.stream()
                    .map(NoteBoxDto::new)
                    .toList();

            NoteBoxListResponseDto data = new NoteBoxListResponseDto(response);
            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<Void> deleteNoteBox(String userEmail, Long noteBoxId) {
        try {
            NoteBox noteBox = noteBoxRepository.findById(noteBoxId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_DATA + "noteBox"));
            noteBoxRepository.delete(noteBox);
            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }
}

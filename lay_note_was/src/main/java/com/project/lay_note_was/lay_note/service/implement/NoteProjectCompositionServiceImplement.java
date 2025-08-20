package com.project.lay_note_was.lay_note.service.implement;

import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.request.CompositionPositionRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.request.CompositionRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.request.CompositionSizeRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.response.CompositionResponseDto;
import com.project.lay_note_was.lay_note.service.NoteProjectCompositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteProjectCompositionServiceImplement implements NoteProjectCompositionService {
    @Override
    public ResponseDto<CompositionResponseDto> createComposition(String userEmail, String noteProjectId, Long targetId, CompositionRequestDto dto) {
        return null;
    }

    @Override
    public ResponseDto<CompositionResponseDto> getComposition(String userEmail, String noteProjectId) {
        return null;
    }

    @Override
    public ResponseDto<CompositionResponseDto> updateSizeComposition(String userEmail, String noteComponentId, CompositionSizeRequestDto dto) {
        return null;
    }

    @Override
    public ResponseDto<CompositionResponseDto> updatePositionComposition(String userEmail, String noteComponentId, CompositionPositionRequestDto dto) {
        return null;
    }
}

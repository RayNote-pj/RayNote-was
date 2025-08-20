package com.project.lay_note_was.lay_note.service;

import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.request.CompositionPositionRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.request.CompositionRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.request.CompositionSizeRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.response.CompositionResponseDto;

public interface NoteProjectCompositionService {
    ResponseDto<CompositionResponseDto> createComposition(String userEmail, String noteProjectId, Long targetId, CompositionRequestDto dto);

    ResponseDto<CompositionResponseDto> getComposition(String userEmail, String noteProjectId);

    ResponseDto<CompositionResponseDto> updateSizeComposition(String userEmail, String noteComponentId, CompositionSizeRequestDto dto);

    ResponseDto<CompositionResponseDto> updatePositionComposition(String userEmail, String noteComponentId, CompositionPositionRequestDto dto);
}

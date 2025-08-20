package com.project.lay_note_was.lay_note.controller;

import com.project.lay_note_was.lay_note.common.constant.ApiMappingPattern;
import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.request.CompositionPositionRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.request.CompositionRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.request.CompositionSizeRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.response.CompositionResponseDto;
import com.project.lay_note_was.lay_note.security.PrincipalUser;
import com.project.lay_note_was.lay_note.service.NoteProjectCompositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiMappingPattern.NOTE_PROJECT_COMPOSITION)
@RequiredArgsConstructor
public class NoteProjectCompositionController {
    private final NoteProjectCompositionService noteProjectCompositionService;

    private final String POST = "/{noteProjectId}/{targetId}/create";
    private final String GET = "/{noteProjectId}/all";
    private final String PUT_SIZE = "/{noteComponentId}/size";
    private final String PUT_POSITION = "/{noteComponentId}/position";

    @PostMapping(POST)
    public ResponseEntity<ResponseDto<CompositionResponseDto>> createComposition (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @PathVariable String noteProjectId,
            @PathVariable Long targetId,
            @RequestBody CompositionRequestDto dto
    ) {
      String userEmail = principalUser.getUsername();
      ResponseDto<CompositionResponseDto> response = noteProjectCompositionService.createComposition(userEmail,noteProjectId, targetId, dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping(GET)
    public ResponseEntity<ResponseDto<CompositionResponseDto>> getComposition (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @PathVariable String noteProjectId
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<CompositionResponseDto> response = noteProjectCompositionService.getComposition(userEmail, noteProjectId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @PutMapping(PUT_SIZE)
    public ResponseEntity<ResponseDto<CompositionResponseDto>> updateSizeComposition (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @PathVariable String noteComponentId,
            @RequestBody CompositionSizeRequestDto dto
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<CompositionResponseDto> response = noteProjectCompositionService.updateSizeComposition(userEmail, noteComponentId, dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @PutMapping(PUT_POSITION)
    public ResponseEntity<ResponseDto<CompositionResponseDto>> updatePositionComposition (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @PathVariable String noteComponentId,
            @RequestBody CompositionPositionRequestDto dto
            ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<CompositionResponseDto> response = noteProjectCompositionService.updatePositionComposition(userEmail, noteComponentId,dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }
}

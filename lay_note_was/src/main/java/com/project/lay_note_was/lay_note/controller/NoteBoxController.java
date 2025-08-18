package com.project.lay_note_was.lay_note.controller;

import com.project.lay_note_was.lay_note.common.constant.ApiMappingPattern;
import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_box.request.NoteBoxCreateRequestDto;
import com.project.lay_note_was.lay_note.dto.note_box.request.NoteBoxUpdateRequestDto;
import com.project.lay_note_was.lay_note.dto.note_box.response.NoteBoxListResponseDto;
import com.project.lay_note_was.lay_note.dto.note_box.response.NoteBoxResponseDto;
import com.project.lay_note_was.lay_note.security.PrincipalUser;
import com.project.lay_note_was.lay_note.service.NoteBoxService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiMappingPattern.NOTE_BOX)
@RequiredArgsConstructor
public class NoteBoxController {
    private final NoteBoxService noteBoxService;

    private final String POST = "/create";
    private final String PUT = "/{noteBoxId}/update";
    private final String DELETE = "/{noteBoxId}/delete";
    private final String GET = "/all";

    @PostMapping(POST)
    public ResponseEntity<ResponseDto<NoteBoxResponseDto>> createNoteBox (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @RequestBody NoteBoxCreateRequestDto dto
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<NoteBoxResponseDto> response = noteBoxService.createNoteBox(userEmail, dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @PutMapping(PUT)
    public ResponseEntity<ResponseDto<NoteBoxResponseDto>> updateNoteBox (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @RequestBody NoteBoxUpdateRequestDto dto,
            @PathVariable Long noteBoxId
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<NoteBoxResponseDto> response = noteBoxService.updateNoteBox(userEmail, dto, noteBoxId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping(GET)
    public ResponseEntity<ResponseDto<NoteBoxListResponseDto>> getNoteBox (
            @AuthenticationPrincipal PrincipalUser principalUser
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<NoteBoxListResponseDto> response = noteBoxService.getNoteBox(userEmail);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<ResponseDto<Void>> delteNoteBox (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @PathVariable Long noteBoxId
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<Void>response = noteBoxService.deleteNoteBox(userEmail, noteBoxId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }
}

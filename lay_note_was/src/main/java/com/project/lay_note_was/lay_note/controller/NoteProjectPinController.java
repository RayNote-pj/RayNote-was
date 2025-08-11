package com.project.lay_note_was.lay_note.controller;

import com.project.lay_note_was.lay_note.common.constant.ApiMappingPattern;
import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project.response.NoteProjectListResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_pin.response.PinListResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_pin.response.PinResponseDto;
import com.project.lay_note_was.lay_note.security.PrincipalUser;
import com.project.lay_note_was.lay_note.service.NoteProjectPinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiMappingPattern.NOTE_PROJECT_PIN)
@RequiredArgsConstructor
public class NoteProjectPinController {
    private final NoteProjectPinService noteProjectPinService;

    private final String GET = "/all";
    private final String POST = "/{noteProjectId}/create";
    private final String DELETE = "/{pinId}/delete";

    @GetMapping(GET)
    public ResponseEntity<ResponseDto<PinListResponseDto>> getPinAll (
            @AuthenticationPrincipal PrincipalUser principalUser
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<PinListResponseDto> response = noteProjectPinService.getPinAll(userEmail);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @PostMapping(POST)
    public ResponseEntity<ResponseDto<PinResponseDto>> createPin (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @PathVariable String noteProjectId
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<PinResponseDto> response = noteProjectPinService.createPin(userEmail, noteProjectId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<ResponseDto<Void>> deletePin (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @PathVariable String pinId
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<Void> response = noteProjectPinService.deletePin(userEmail, pinId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

}

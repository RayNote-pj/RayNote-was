package com.project.lay_note_was.lay_note.controller;

import com.project.lay_note_was.lay_note.common.constant.ApiMappingPattern;
import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_join.request.NoteProjectJoinRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_join.response.NoteProjectJoinListResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_join.response.NoteProjectJoinResponseDto;
import com.project.lay_note_was.lay_note.entity.note_project_join.JoinStatus;
import com.project.lay_note_was.lay_note.entity.note_project_user.UserRole;
import com.project.lay_note_was.lay_note.security.PrincipalUser;
import com.project.lay_note_was.lay_note.service.NoteProjectJoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiMappingPattern.NOTE_PROJECT_JOIN)
@RequiredArgsConstructor
public class NoteProjectJoinController {
    private final NoteProjectJoinService NoteProjectJoinService;

    private final String POST = "/{noteProjectId}/project-apply";
    private final String PUT = "/{noteProjectJoinId}/apply-state-change";
    private final String GET = "/{noteProjectId}";

    @PostMapping(POST)
    public ResponseEntity<ResponseDto<NoteProjectJoinResponseDto>> createJoin (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @PathVariable String noteProjectId,
            @RequestBody NoteProjectJoinRequestDto dto
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<NoteProjectJoinResponseDto> response = NoteProjectJoinService.createJoin(userEmail, noteProjectId, dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @PutMapping(PUT)
    public ResponseEntity<ResponseDto<NoteProjectJoinResponseDto>> changeJoinStatus (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @PathVariable String noteProjectJoinId,
            @RequestParam JoinStatus joinStatus,
            @RequestParam(required = false) UserRole role
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<NoteProjectJoinResponseDto> response = NoteProjectJoinService.changeJoinStatus(userEmail, noteProjectJoinId, joinStatus, role);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping(GET)
    public ResponseEntity<ResponseDto<NoteProjectJoinListResponseDto>> getJoin (
            @AuthenticationPrincipal PrincipalUser principalUser,
            @PathVariable String noteProjectId
    ) {
        String userEmail = principalUser.getUsername();
        ResponseDto<NoteProjectJoinListResponseDto> response = NoteProjectJoinService.getJoin(userEmail, noteProjectId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }
}

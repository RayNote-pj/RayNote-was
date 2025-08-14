package com.project.lay_note_was.lay_note.service;

import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_join.request.NoteProjectJoinRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_join.response.NoteProjectJoinListResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_join.response.NoteProjectJoinResponseDto;
import com.project.lay_note_was.lay_note.entity.note_project_join.JoinStatus;
import com.project.lay_note_was.lay_note.entity.note_project_user.UserRole;

public interface NoteProjectJoinService {

    ResponseDto<NoteProjectJoinResponseDto> createJoin(String userEmail, String noteProjectId, NoteProjectJoinRequestDto dto);

    ResponseDto<NoteProjectJoinResponseDto> changeJoinStatus(String userEmail, String noteProjectJoinId, JoinStatus joinStatus, UserRole role);

    ResponseDto<NoteProjectJoinListResponseDto> getJoin(String userEmail, String noteProjectId);
}

package com.project.lay_note_was.lay_note.service.implement;

import com.project.lay_note_was.lay_note.common.constant.ResponseMessage;
import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_box.NoteBoxDto;
import com.project.lay_note_was.lay_note.dto.note_box.request.NoteBoxCreateRequestDto;
import com.project.lay_note_was.lay_note.dto.note_box.request.NoteBoxUpdateRequestDto;
import com.project.lay_note_was.lay_note.dto.note_box.response.NoteBoxListResponseDto;
import com.project.lay_note_was.lay_note.dto.note_box.response.NoteBoxResponseDto;
import com.project.lay_note_was.lay_note.entity.note_box.NoteBox;
import com.project.lay_note_was.lay_note.entity.note_project.NoteProject;
import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteComponentType;
import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteProjectComposition;
import com.project.lay_note_was.lay_note.entity.note_project_user.NoteProjectUser;
import com.project.lay_note_was.lay_note.entity.note_project_user.UserRole;
import com.project.lay_note_was.lay_note.repository.NoteBoxRepository;
import com.project.lay_note_was.lay_note.repository.NoteProjectCompositionRepository;
import com.project.lay_note_was.lay_note.repository.NoteProjectRepository;
import com.project.lay_note_was.lay_note.repository.NoteProjectUserRepository;
import com.project.lay_note_was.lay_note.service.NoteBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteBoxServiceImplement implements NoteBoxService {

    private final NoteBoxRepository noteBoxRepository;
    private final NoteProjectUserRepository noteProjectUserRepository;
    private final NoteProjectRepository noteProjectRepository;
    private final NoteProjectCompositionRepository noteProjectCompositionRepository;

    @Override
    public ResponseDto<NoteBoxResponseDto> createNoteBox(String userEmail, String noteProjectId, NoteBoxCreateRequestDto dto) {
        try {
            NoteProjectUser projectUser = noteProjectUserRepository.findByUser_UserEmailAndNoteProject_NoteProjectId(userEmail, noteProjectId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_NOTE_PROJECT_MEMBER));

            if(!(projectUser.getUserRole() == UserRole.OWNER || projectUser.getUserRole() == UserRole.MEMBER)) {
                return ResponseDto.setFailed(ResponseMessage.NO_PERMISSION);
            }

            NoteProject noteProject = noteProjectRepository.findById(noteProjectId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_DATA + "noteProject"));

            NoteBox noteBox = NoteBox.builder()
                    .noteBoxTitle(dto.getNoteBoxTitle())
                    .noteBoxContent(dto.getNoteBoxContent())
                    .imageUrl(dto.getImageUrl())
                    .build();
            noteBoxRepository.save(noteBox);
            NoteProjectComposition composition = NoteProjectComposition.builder()
                    .noteComponentType(NoteComponentType.NOTEBOX)
                    .noteComponentId(noteBox.getNoteBoxId())
                    .noteProject(noteProject)
                    .build();
            noteProjectCompositionRepository.save(composition);
            NoteBoxDto response = new NoteBoxDto(noteBox);
            NoteBoxResponseDto data = new NoteBoxResponseDto(response);

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (IllegalArgumentException e) {
            return ResponseDto.setFailed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<NoteBoxResponseDto> updateNoteBox(String userEmail, String noteProjectId, NoteBoxUpdateRequestDto dto, Long noteBoxId) {
        try {
            NoteProjectUser projectUser = noteProjectUserRepository.findByUser_UserEmailAndNoteProject_NoteProjectId(userEmail, noteProjectId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_NOTE_PROJECT_MEMBER));

            if(!(projectUser.getUserRole() == UserRole.OWNER || projectUser.getUserRole() == UserRole.MEMBER)) {
                return ResponseDto.setFailed(ResponseMessage.NO_PERMISSION);
            }

            NoteBox noteBox = noteBoxRepository.findById(noteBoxId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_DATA + "noteBox"));

            noteBox.setNoteBoxTitle(dto.getNoteBoxTitle());
            noteBox.setNoteBoxContent(dto.getNoteBoxContent());
            noteBox.setImageUrl(dto.getImageUrl());

            NoteBoxDto response = new NoteBoxDto(noteBox);
            NoteBoxResponseDto data = new NoteBoxResponseDto(response);

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (IllegalArgumentException e) {
            return ResponseDto.setFailed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<NoteBoxListResponseDto> getNoteBox(String userEmail, String noteProjectId) {
        try {
            NoteProjectUser projectUser = noteProjectUserRepository.findByUser_UserEmailAndNoteProject_NoteProjectId(userEmail, noteProjectId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_NOTE_PROJECT_MEMBER));

            if(!(projectUser.getUserRole() == UserRole.OWNER || projectUser.getUserRole() == UserRole.MEMBER)) {
                return ResponseDto.setFailed(ResponseMessage.NO_PERMISSION);
            }

            List<NoteBox> noteBoxes = noteBoxRepository.findAll();

            List<NoteBoxDto> response = noteBoxes.stream()
                    .map(NoteBoxDto::new)
                    .toList();

            NoteBoxListResponseDto data = new NoteBoxListResponseDto(response);
            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (IllegalArgumentException e) {
            return ResponseDto.setFailed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<Void> deleteNoteBox(String userEmail, String noteProjectId, Long noteBoxId) {
        try {
            NoteProjectUser projectUser = noteProjectUserRepository.findByUser_UserEmailAndNoteProject_NoteProjectId(userEmail, noteProjectId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_NOTE_PROJECT_MEMBER));

            if(!(projectUser.getUserRole() == UserRole.OWNER || projectUser.getUserRole() == UserRole.MEMBER)) {
                return ResponseDto.setFailed(ResponseMessage.NO_PERMISSION);
            }

            NoteBox noteBox = noteBoxRepository.findById(noteBoxId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_DATA + "noteBox"));
            noteBoxRepository.delete(noteBox);
            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, null);
        } catch (IllegalArgumentException e) {
            return ResponseDto.setFailed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

}

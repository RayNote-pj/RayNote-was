package com.project.lay_note_was.lay_note.service.implement;

import com.project.lay_note_was.lay_note.common.constant.ResponseMessage;
import com.project.lay_note_was.lay_note.dto.ResponseDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.request.CompositionPositionRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.request.CompositionSizeRequestDto;
import com.project.lay_note_was.lay_note.dto.note_project_composition.response.CompositionResponseDto;
import com.project.lay_note_was.lay_note.entity.note_box.NoteBox;
import com.project.lay_note_was.lay_note.entity.note_image_box.NoteImageBoxList;
import com.project.lay_note_was.lay_note.entity.note_list.NoteList;
import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteComponentType;
import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteProjectComposition;
import com.project.lay_note_was.lay_note.entity.note_project_user.NoteProjectUser;
import com.project.lay_note_was.lay_note.entity.note_project_user.UserRole;
import com.project.lay_note_was.lay_note.repository.*;
import com.project.lay_note_was.lay_note.service.NoteImageBoxListService;
import com.project.lay_note_was.lay_note.service.NoteListService;
import com.project.lay_note_was.lay_note.service.NoteProjectCompositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteProjectCompositionServiceImplement implements NoteProjectCompositionService {
    private final NoteProjectUserRepository noteProjectUserRepository;
    private final NoteProjectCompositionRepository noteProjectCompositionRepository;
    private final NoteListRepository noteListRepository;
    private final NoteBoxRepository noteBoxRepository;
    private final NoteImageBoxRepository noteImageBoxRepository;
    private final NoteImageBoxListRepository noteImageBoxListRepository;

    @Override
    public ResponseDto<List<CompositionResponseDto>> getComposition(String userEmail, String noteProjectId) {
        try {
            List<NoteProjectComposition> composition = noteProjectCompositionRepository.findAllByNoteProject_User_UserEmailAndNoteProject_NoteProjectId(userEmail, noteProjectId);

            List<CompositionResponseDto> data =  composition.stream()
                    .map(c -> {
                        switch (c.getNoteComponentType()) {
                            case NOTELIST -> {
                                NoteList list = noteListRepository.findById(c.getNoteComponentId()).orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_DATA));
                                return new CompositionResponseDto(c, list);
                            }
                            case NOTEBOX -> {
                                NoteBox box = noteBoxRepository.findById(c.getNoteComponentId()).orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_DATA));
                                return new CompositionResponseDto(c, box);
                            }
                            case NOTEIMAGEBOX -> {
                                NoteImageBoxList imageBoxList = noteImageBoxListRepository.findById(c.getNoteComponentId()).orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_DATA));
                                return new CompositionResponseDto(c, imageBoxList);
                            }
                            default -> throw new IllegalArgumentException("알 수 없는 타입");
                        }
                    })
                    .toList();

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (IllegalArgumentException e) {
            return ResponseDto.setFailed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<CompositionResponseDto> updateSizeComposition(String userEmail,  String noteCompositionId, Long noteComponentId, String noteProjectId, CompositionSizeRequestDto dto) {
        try {
            NoteProjectUser projectUser = noteProjectUserRepository.findByUser_UserEmailAndNoteProject_NoteProjectId(userEmail, noteProjectId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_USER));
            if(!(projectUser.getUserRole() == UserRole.OWNER || projectUser.getUserRole() == UserRole.MEMBER)) {
                return ResponseDto.setFailed(ResponseMessage.NO_PERMISSION);
            }

            NoteProjectComposition projectComposition = noteProjectCompositionRepository.findByNoteCompositionIdAndNoteComponentId(noteCompositionId, noteComponentId);

            NoteProjectComposition composition = projectComposition.toBuilder()
                    .compositionWidth(dto.getCompositionWidth())
                    .compositionHeight(dto.getCompositionHeight())
                    .build();
            CompositionResponseDto data = new CompositionResponseDto(composition);
            noteProjectCompositionRepository.save(composition);
            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (IllegalArgumentException e) {
            return ResponseDto.setFailed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);
        }
    }

    @Override
    public ResponseDto<CompositionResponseDto> updatePositionComposition(String userEmail, String noteCompositionId, Long noteComponentId, String noteProjectId, CompositionPositionRequestDto dto) {
        try {
            NoteProjectUser projectUser = noteProjectUserRepository.findByUser_UserEmailAndNoteProject_NoteProjectId(userEmail, noteProjectId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_USER));
            if(!(projectUser.getUserRole() == UserRole.OWNER || projectUser.getUserRole() == UserRole.MEMBER)) {
                return ResponseDto.setFailed(ResponseMessage.NO_PERMISSION);
            }

            NoteProjectComposition projectComposition = noteProjectCompositionRepository.findByNoteCompositionIdAndNoteComponentId(noteCompositionId, noteComponentId);

            NoteProjectComposition composition = projectComposition.toBuilder()
                    .compositionX(dto.getCompositionX())
                    .compositionZ(dto.getCompositionZ())
                    .compositionZ2(dto.getCompositionZ2())
                    .build();
            noteProjectCompositionRepository.save(composition);
            CompositionResponseDto data = new CompositionResponseDto(composition);

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (IllegalArgumentException e) {
            return ResponseDto.setFailed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);
        }
    }
}

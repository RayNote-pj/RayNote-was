package com.project.lay_note_was.lay_note.dto.note_project_user.response;

import com.project.lay_note_was.lay_note.dto.note_project_user.NoteProjectUserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteProjectUserListResponseDto {
    private List<NoteProjectUserDto> noteProjectUserDtoList;
}

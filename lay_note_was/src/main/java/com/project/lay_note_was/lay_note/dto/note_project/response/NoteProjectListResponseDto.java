package com.project.lay_note_was.lay_note.dto.note_project.response;

import com.project.lay_note_was.lay_note.dto.note_project.NoteProjectDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteProjectListResponseDto {
    private List<NoteProjectDto> noteProjects;
}

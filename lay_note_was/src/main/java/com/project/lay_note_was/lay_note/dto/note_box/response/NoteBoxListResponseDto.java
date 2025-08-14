package com.project.lay_note_was.lay_note.dto.note_box.response;

import com.project.lay_note_was.lay_note.dto.note_box.NoteBoxDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NoteBoxListResponseDto {
    private List<NoteBoxDto> noteBoxDtoList;
}

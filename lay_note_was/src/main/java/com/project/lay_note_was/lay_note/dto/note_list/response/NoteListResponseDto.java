package com.project.lay_note_was.lay_note.dto.note_list.response;

import com.project.lay_note_was.lay_note.dto.note_list.NoteListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoteListResponseDto {
    private List<NoteListDto> noteList;

}

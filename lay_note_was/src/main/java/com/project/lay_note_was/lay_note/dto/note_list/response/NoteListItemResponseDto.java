package com.project.lay_note_was.lay_note.dto.note_list.response;

import com.project.lay_note_was.lay_note.dto.note_list.NoteListItemDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NoteListItemResponseDto {
    private Long noteListId;
    private String noteListTitle;
    private NoteListItemDto noteListItemDto;

    public NoteListItemResponseDto(NoteListItemDto response) {
        this.noteListId = response.getNoteList().getNoteListId();
        this.noteListTitle = response.getNoteList().getNoteListTitle();
        this.noteListItemDto = response;
    }
}

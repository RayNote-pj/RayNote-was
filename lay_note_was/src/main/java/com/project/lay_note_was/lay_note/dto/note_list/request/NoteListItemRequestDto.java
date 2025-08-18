package com.project.lay_note_was.lay_note.dto.note_list.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteListItemRequestDto {
    private String noteListContent;
    private boolean noteListCheck;
}

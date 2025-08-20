package com.project.lay_note_was.lay_note.dto.note_image_box;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NoteImageBoxListOneDto {
    private Long noteImageBoxListId;
    private NoteImageBoxDto noteImageBoxDto;

    public NoteImageBoxListOneDto(NoteImageBoxDto response) {
        this.noteImageBoxListId = response.getNoteImageBoxList().getNoteImageBoxListId();
        this.noteImageBoxDto = response;
    }
}

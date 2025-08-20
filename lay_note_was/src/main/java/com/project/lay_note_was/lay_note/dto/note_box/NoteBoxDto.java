package com.project.lay_note_was.lay_note.dto.note_box;

import com.project.lay_note_was.lay_note.entity.note_box.NoteBox;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NoteBoxDto {
    private Long noteBoxId;
    private String noteBoxTitle;
    private String noteBoxContent;
    private String imageUrl;

    public NoteBoxDto(NoteBox noteBox) {
        this.noteBoxId = noteBox.getNoteBoxId();
        this.noteBoxTitle = noteBox.getNoteBoxTitle();
        this.noteBoxContent = noteBox.getNoteBoxContent();
        this.imageUrl = noteBox.getImageUrl();
    }
}

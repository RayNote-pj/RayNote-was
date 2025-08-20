package com.project.lay_note_was.lay_note.dto.note_box.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteBoxCreateRequestDto {
    private String noteBoxTitle;
    private String noteBoxContent;
    private String imageUrl;
}

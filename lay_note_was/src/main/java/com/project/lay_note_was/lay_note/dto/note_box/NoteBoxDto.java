package com.project.lay_note_was.lay_note.dto.note_box;

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
}

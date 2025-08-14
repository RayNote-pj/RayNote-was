package com.project.lay_note_was.lay_note.dto.note_box.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteBoxCreateRequestDto {
    @NotBlank
    private String noteBoxTitle;
    @NotBlank
    private Long noteBoxContent;
    @NotBlank
    private Long imageUrl;
}

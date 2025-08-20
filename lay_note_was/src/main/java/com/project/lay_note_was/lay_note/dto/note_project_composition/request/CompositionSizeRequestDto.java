package com.project.lay_note_was.lay_note.dto.note_project_composition.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompositionSizeRequestDto {
    private int  compositionWidth;
    private int  compositionHeight;
}

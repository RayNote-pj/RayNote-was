package com.project.lay_note_was.lay_note.dto.note_project_composition.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompositionPositionRequestDto {
    private int  compositionX;
    private int  compositionY;
    private int  compositionZ;
    private int  compositionZ2;
}

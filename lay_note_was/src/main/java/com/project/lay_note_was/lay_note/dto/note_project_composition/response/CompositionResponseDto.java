package com.project.lay_note_was.lay_note.dto.note_project_composition.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.lay_note_was.lay_note.entity.note_project.NoteProject;
import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteComponentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompositionResponseDto {
    private String noteCompositionId;
    @JsonIgnore
    private NoteProject noteProject;
    private Long noteComponentId;
    private NoteComponentType noteComponentType;
    private int  compositionWidth;
    private int  compositionHeight;
    private int  compositionX;
    private int  compositionY;
    private int  compositionZ;
    private int  compositionZ2;
}

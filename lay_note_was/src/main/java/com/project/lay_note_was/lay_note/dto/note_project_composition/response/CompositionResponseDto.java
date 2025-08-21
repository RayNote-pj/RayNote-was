package com.project.lay_note_was.lay_note.dto.note_project_composition.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.lay_note_was.lay_note.dto.note_box.NoteBoxDto;
import com.project.lay_note_was.lay_note.dto.note_box.response.NoteBoxResponseDto;
import com.project.lay_note_was.lay_note.dto.note_image_box.NoteImageBoxDto;
import com.project.lay_note_was.lay_note.dto.note_image_box.NoteImageBoxListDto;
import com.project.lay_note_was.lay_note.dto.note_list.response.NoteListOneResponseDto;
import com.project.lay_note_was.lay_note.entity.note_box.NoteBox;
import com.project.lay_note_was.lay_note.entity.note_image_box.NoteImageBoxList;
import com.project.lay_note_was.lay_note.entity.note_list.NoteList;
import com.project.lay_note_was.lay_note.entity.note_project.NoteProject;
import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteComponentType;
import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteProjectComposition;
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
    private int compositionWidth;
    private int compositionHeight;
    private int compositionX;
    private int compositionY;
    private int compositionZ;
    private int compositionZ2;

    private NoteBoxResponseDto noteBox;
    private NoteListOneResponseDto noteList;
    private NoteImageBoxListDto noteImageBoxList;

    public CompositionResponseDto(NoteProjectComposition noteProjectComposition) {
        this.noteCompositionId = noteProjectComposition.getNoteCompositionId();
        this.noteProject = noteProjectComposition.getNoteProject();
        this.noteComponentId = noteProjectComposition.getNoteComponentId();
        this.noteComponentType = noteProjectComposition.getNoteComponentType();
        this.compositionWidth = noteProjectComposition.getCompositionWidth();
        this.compositionHeight = noteProjectComposition.getCompositionHeight();
        this.compositionX = noteProjectComposition.getCompositionX();
        this.compositionY = noteProjectComposition.getCompositionY();
        this.compositionZ = noteProjectComposition.getCompositionZ();
        this.compositionZ2 = noteProjectComposition.getCompositionZ2();
    }

    public CompositionResponseDto(NoteProjectComposition c, NoteList list) {
        this.noteCompositionId = c.getNoteCompositionId();
        this.noteProject = c.getNoteProject();
        this.noteComponentId = c.getNoteComponentId();
        this.noteComponentType = c.getNoteComponentType();
        this.compositionWidth = c.getCompositionWidth();
        this.compositionHeight = c.getCompositionHeight();
        this.compositionX = c.getCompositionX();
        this.compositionY = c.getCompositionY();
        this.compositionZ = c.getCompositionZ();
        this.compositionZ2 = c.getCompositionZ2();
        this.noteList = new NoteListOneResponseDto(list);
    }

    public CompositionResponseDto(NoteProjectComposition c, NoteBox box) {
        this.noteCompositionId = c.getNoteCompositionId();
        this.noteProject = c.getNoteProject();
        this.noteComponentId = c.getNoteComponentId();
        this.noteComponentType = c.getNoteComponentType();
        this.compositionWidth = c.getCompositionWidth();
        this.compositionHeight = c.getCompositionHeight();
        this.compositionX = c.getCompositionX();
        this.compositionY = c.getCompositionY();
        this.compositionZ = c.getCompositionZ();
        this.compositionZ2 = c.getCompositionZ2();
        this.noteBox = new NoteBoxResponseDto(new NoteBoxDto(box));
    }

    public CompositionResponseDto(NoteProjectComposition c, NoteImageBoxList imageBoxList) {
        this.noteCompositionId = c.getNoteCompositionId();
        this.noteProject = c.getNoteProject();
        this.noteComponentId = c.getNoteComponentId();
        this.noteComponentType = c.getNoteComponentType();
        this.compositionWidth = c.getCompositionWidth();
        this.compositionHeight = c.getCompositionHeight();
        this.compositionX = c.getCompositionX();
        this.compositionY = c.getCompositionY();
        this.compositionZ = c.getCompositionZ();
        this.compositionZ2 = c.getCompositionZ2();
        this.noteImageBoxList = new NoteImageBoxListDto(imageBoxList.getNoteImageBoxListId(), imageBoxList.getNoteImageBoxes().stream()
                .map(NoteImageBoxDto::new)
                .toList()
        );
    }
}


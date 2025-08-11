package com.project.lay_note_was.lay_note.dto.note_project;

import com.project.lay_note_was.lay_note.entity.note_project.NoteProject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteProjectDto {
    private String noteProjectId;
    private String noteProjectImageUrl;
    private String noteProjectOwnerId;
    private String noteProjectTitle;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public NoteProjectDto(NoteProject noteProject) {
        this.noteProjectId = noteProject.getNoteProjectId();
        this.noteProjectImageUrl = noteProject.getNoteProjectImageUrl();
        this.noteProjectOwnerId = noteProject.getUser().getUserId();
        this.noteProjectTitle = noteProject.getNoteProjectTitle();
        this.createdAt = noteProject.getCreatedAt();
        this.updatedAt = noteProject.getUpdatedAt();
        this.deletedAt = noteProject.getDeletedAt();
    }


}

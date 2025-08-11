package com.project.lay_note_was.lay_note.dto.note_project_pin;

import com.project.lay_note_was.lay_note.entity.note_project_pin.NoteProjectPin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PinDto {
    private String noteProjectId;
    private String noteProjectImageUrl;
    private String noteProjectOwnerId;
    private String noteProjectTitle;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public PinDto(NoteProjectPin noteProjectPin) {
        this.noteProjectId = noteProjectPin.getNoteProject().getNoteProjectId();
        this.noteProjectImageUrl = noteProjectPin.getNoteProject().getNoteProjectImageUrl();
        this.noteProjectOwnerId = noteProjectPin.getNoteProject().getUser().getUserId();
        this.noteProjectTitle = noteProjectPin.getNoteProject().getNoteProjectTitle();
        this.createdAt = noteProjectPin.getNoteProject().getCreatedAt();
        this.updatedAt = noteProjectPin.getNoteProject().getUpdatedAt();
        this.deletedAt = noteProjectPin.getNoteProject().getDeletedAt();
    }
}

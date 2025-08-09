package com.project.lay_note_was.lay_note.entity.note_project_user;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteProjectUserId {

    private String userId;
    private String noteProjectId;
}

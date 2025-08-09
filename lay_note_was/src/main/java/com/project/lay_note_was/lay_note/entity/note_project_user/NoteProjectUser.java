package com.project.lay_note_was.lay_note.entity.note_project_user;

import com.project.lay_note_was.lay_note.entity.note_project.NoteProject;
import com.project.lay_note_was.lay_note.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "note_project_users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class NoteProjectUser {
    @EmbeddedId
    private NoteProjectUserId id;

    @ManyToOne
    @MapsId("noteProjectId")
    @JoinColumn(name = "note_project_id", columnDefinition = "CHAR(36)")
    private NoteProject noteProject;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "note_project_owner_id", columnDefinition = "CHAR(36)")
    private User user;

    @Column(name = "note_project_image_url", nullable = false)
    private String noteProjectImageUrl;

    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

}

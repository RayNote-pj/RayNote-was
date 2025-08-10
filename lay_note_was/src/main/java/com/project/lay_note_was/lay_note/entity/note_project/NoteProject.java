package com.project.lay_note_was.lay_note.entity.note_project;

import com.project.lay_note_was.lay_note.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "note_projects")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class NoteProject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "note_project_id", columnDefinition = "CHAR(36)")
    private String noteProjectId;

    @Column(name = "note_project_image_url", nullable = false)
    private String noteProjectImageUrl;

    @ManyToOne
    @JoinColumn(name = "note_project_owner_id", nullable = false)
    private User user;

    @Column(name = "note_project_title", nullable = false)
    private String noteProjectTitle;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", nullable = false)
    private LocalDateTime deletedAt;

}

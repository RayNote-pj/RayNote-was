package com.project.lay_note_was.lay_note.entity.note_project_join;

import com.project.lay_note_was.lay_note.entity.note_project.NoteProject;
import com.project.lay_note_was.lay_note.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "note_project_joins")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteProjectJoin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "note_project_join_id", columnDefinition = "CHAR(36)")
    private String noteProjectJoinId;

    @ManyToOne
    @JoinColumn(name = "note_project_id", columnDefinition = "CHAR(36)")
    private NoteProject noteProject;

    @ManyToOne
    @JoinColumn(name = "note_project_owner_id", columnDefinition = "CHAR(36)")
    private User user;

    @Column(name = "join_status", nullable = false)
    private JoinStatus joinStatus;
}

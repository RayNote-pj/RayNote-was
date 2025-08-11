package com.project.lay_note_was.lay_note.entity.note_project_pin;

import com.project.lay_note_was.lay_note.entity.note_project.NoteProject;
import com.project.lay_note_was.lay_note.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "note_project_pins")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class NoteProjectPin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pin_id", columnDefinition = "CHAR(36)")
    private String pinId;

    @ManyToOne
    @JoinColumn(name = "note_project_id", columnDefinition = "CHAR(36)")
    private NoteProject noteProject;

    @ManyToOne
    @JoinColumn(name = "user_id", columnDefinition = "CHAR(36)")
    private User user;
}

package com.project.lay_note_was.lay_note.entity.note_image_box;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "note_image_box_list")
@NoArgsConstructor
@AllArgsConstructor
public class NoteImageBoxList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_image_box_list_id")
    private Long noteImageBoxListId;

    @ManyToOne
    @JoinColumn(name = "note_image_box_id", nullable = false)
    private NoteImageBox noteImageBox;
}

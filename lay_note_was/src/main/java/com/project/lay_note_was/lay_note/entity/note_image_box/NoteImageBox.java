package com.project.lay_note_was.lay_note.entity.note_image_box;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "note_image_boxs")
@NoArgsConstructor
@AllArgsConstructor
public class NoteImageBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_image_box_id")
    private Long noteImageBoxId;

    @Column(name = "image_caption")
    private Long imageCaption;

    @Column(name = "image_url")
    private Long imageUrl;
}

package com.project.lay_note_was.lay_note.entity.note_box;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "note_boxs")
@NoArgsConstructor
@AllArgsConstructor
public class NoteBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_box_id")
    private Long noteBoxId;

    @Column(name = "note_box_title")
    private String noteBoxTitle;

    @Column(name = "note_box_content")
    private String noteBoxContent;

    @Column(name = "image_url")
    private String imageUrl;
}

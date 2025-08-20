package com.project.lay_note_was.lay_note.entity.note_image_box;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "note_image_box_list")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class NoteImageBoxList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_image_box_list_id")
    private Long noteImageBoxListId;

    @OneToMany(mappedBy = "noteImageBoxList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoteImageBox> noteImageBoxes;
}

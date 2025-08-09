package com.project.lay_note_was.lay_note.entity.note_project_composition;

import com.project.lay_note_was.lay_note.entity.note_project.NoteProject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "note_project_compositions")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteProjectComposition {
    @Id
    @Column(name = "note_composition_id", columnDefinition = "CHAR(36)")
    private String noteCompositionId;

    @ManyToOne
    @MapsId("noteProjectId")
    @JoinColumn(name = "note_project_id", columnDefinition = "CHAR(36)")
    private NoteProject noteProject;

    @Column(name = "note_component_id", nullable = false)
    private Long noteComponentId;

    @Column(name = "note_component_type", nullable = false)
    private NoteComponentType noteComponentType;

    @Column(name = "composition_width", nullable = false)
    private int  compositionWidth;

     @Column(name = "composition_height", nullable = false)
    private int  compositionHeight;

     @Column(name = "composition_x", nullable = false)
    private int  compositionX;

     @Column(name = "composition_y", nullable = false)
    private int  compositionY;

     @Column(name = "composition_z", nullable = false)
    private int  compositionZ;

     @Column(name = "composition_z2", nullable = false)
    private int  compositionZ2;


}

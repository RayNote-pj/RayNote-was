package com.project.lay_note_was.lay_note.dto.note_image_box;

import com.project.lay_note_was.lay_note.entity.note_image_box.NoteImageBoxList;
import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteProjectComposition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NoteImageBoxListDto {
    private Long noteImageBoxListId;
    private List<NoteImageBoxDto> noteImageBoxDto;
}

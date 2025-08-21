package com.project.lay_note_was.lay_note.dto.note_image_box;

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

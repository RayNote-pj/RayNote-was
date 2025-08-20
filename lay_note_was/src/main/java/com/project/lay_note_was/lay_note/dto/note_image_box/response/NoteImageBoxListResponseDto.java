package com.project.lay_note_was.lay_note.dto.note_image_box.response;

import com.project.lay_note_was.lay_note.dto.note_image_box.NoteImageBoxListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NoteImageBoxListResponseDto {
    private List<NoteImageBoxListDto> noteImageBoxListDto;

}

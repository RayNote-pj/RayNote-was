package com.project.lay_note_was.lay_note.dto.note_project.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteProjectCreateRequestDto {
    @NotBlank(message = "프로젝트 제목은 필수 입력 값입니다.")
    private String noteProjectImageUrl;
    @NotBlank(message = "대표 이미지는 필수 입력 값입니다.")
    private String noteProjectTitle;
}

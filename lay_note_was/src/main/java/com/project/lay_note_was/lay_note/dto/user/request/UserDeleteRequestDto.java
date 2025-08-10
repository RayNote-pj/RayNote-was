package com.project.lay_note_was.lay_note.dto.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDeleteRequestDto {
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;
}

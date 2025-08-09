package com.project.lay_note_was.lay_note.dto.auth.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    @NotBlank(message = "이메일은 필수입니다.")
    private String userEmail;
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;
}

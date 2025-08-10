package com.project.lay_note_was.lay_note.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDto {
    private String userName;
    private String nickName;
    private String userPhone;
    private String profileImageUrl;
}

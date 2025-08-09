package com.project.lay_note_was.lay_note.dto.auth.response;

import com.project.lay_note_was.lay_note.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponseDto {
    private String userEmail;
    private String password;
    private String userName;
    private String nickName;
    private String userPhone;
    private String profileImageUrl;

    public SignUpResponseDto(User user) {
        this.userEmail = user.getUserEmail();
        this.nickName = user.getNickName();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.userPhone = user.getUserPhone();
        this.profileImageUrl = user.getProfileImageUrl();
    }
}

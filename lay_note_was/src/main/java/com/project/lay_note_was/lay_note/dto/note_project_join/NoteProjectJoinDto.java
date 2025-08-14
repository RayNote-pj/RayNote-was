package com.project.lay_note_was.lay_note.dto.note_project_join;

import com.project.lay_note_was.lay_note.entity.note_project_join.JoinStatus;
import com.project.lay_note_was.lay_note.entity.note_project_join.NoteProjectJoin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteProjectJoinDto {
    private String noteProjectJoinId;
    private String noteProjectId;
    private String userEmail;
    private JoinStatus joinStatus;

    public NoteProjectJoinDto(NoteProjectJoin noteProjectJoin) {
        this.noteProjectJoinId = noteProjectJoin.getNoteProjectJoinId();
        this.noteProjectId = noteProjectJoin.getNoteProject().getNoteProjectId();
        this.userEmail = noteProjectJoin.getUser().getUserEmail();
        this.joinStatus = noteProjectJoin.getJoinStatus();
    }

}

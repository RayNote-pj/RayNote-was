package com.project.lay_note_was.lay_note.repository;

import com.project.lay_note_was.lay_note.entity.note_project_pin.NoteProjectPin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteProjectPinRepository extends JpaRepository<NoteProjectPin, String> {
    List<NoteProjectPin> findByUser_UserEmailOrderByNoteProject_UpdatedAtDesc(String userEmail);

    NoteProjectPin findByPinId(String pinId);
}

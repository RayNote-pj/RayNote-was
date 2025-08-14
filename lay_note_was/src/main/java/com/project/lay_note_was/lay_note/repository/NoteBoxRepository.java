package com.project.lay_note_was.lay_note.repository;

import com.project.lay_note_was.lay_note.entity.note_box.NoteBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteBoxRepository extends JpaRepository<NoteBox, Long> {
    
}

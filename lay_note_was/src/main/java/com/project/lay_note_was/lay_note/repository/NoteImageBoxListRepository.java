package com.project.lay_note_was.lay_note.repository;

import com.project.lay_note_was.lay_note.entity.note_image_box.NoteImageBoxList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteImageBoxListRepository extends JpaRepository<NoteImageBoxList, Long> {
}

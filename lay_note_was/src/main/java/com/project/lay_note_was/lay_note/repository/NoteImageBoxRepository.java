package com.project.lay_note_was.lay_note.repository;

import com.project.lay_note_was.lay_note.entity.note_image_box.NoteImageBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteImageBoxRepository extends JpaRepository<NoteImageBox, Long> {
    List<NoteImageBox> findAllByNoteImageBoxList_NoteImageBoxListId(Long noteImageBoxListId);
}

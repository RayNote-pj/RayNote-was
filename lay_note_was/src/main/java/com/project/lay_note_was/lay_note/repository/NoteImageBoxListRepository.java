package com.project.lay_note_was.lay_note.repository;

import com.project.lay_note_was.lay_note.entity.note_image_box.NoteImageBoxList;
import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteComponentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteImageBoxListRepository extends JpaRepository<NoteImageBoxList, Long> {
    Optional<NoteImageBoxList> findByNoteImageBoxListId(Long noteImageBoxListId);

    @Query("""
    SELECT nib FROM NoteImageBoxList nib
    JOIN NoteProjectComposition nc
    JOIN nc.noteProject p
    JOIN p.user u
    LEFT JOIN FETCH nib.noteImageBoxes
    WHERE p.noteProjectId = :noteProjectId
    AND nc.noteComponentType = :noteComponentType
    AND u.userEmail = :userEmail
""")
    List<NoteImageBoxList> findAllByUserEmailAndCompositionId(
            @Param("userEmail") String userEmail,
            @Param("noteProjectId") String noteProjectId,
            @Param("noteComponentType")NoteComponentType noteComponentType
    );
}

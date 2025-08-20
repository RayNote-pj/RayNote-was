package com.project.lay_note_was.lay_note.repository;

import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteComponentType;
import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteProjectComposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteProjectCompositionRepository extends JpaRepository<NoteProjectComposition, String> {

    @Query("""
    SELECT c FROM NoteProjectComposition c
    WHERE c.noteComponentType = :noteComponentType AND c.noteComponentId = :noteListId
""")
    Optional<NoteProjectComposition> findByComponentTypeAndTargetId(@Param("noteComponentType") NoteComponentType noteComponentType, @Param("noteListId") Long targetId);

    @Query("""
    SELECT c FROM NoteProjectComposition c
    WHERE c.noteComponentType = :noteComponentType 
    AND c.noteComponentId = :noteListId
    AND c.noteProject.noteProjectId = :noteProjectId
""")
    Optional<NoteProjectComposition> findByComponentTypeAndTargetIdAndNoteProject_noteProjectId(
            @Param("noteComponentType") NoteComponentType noteComponentType,
            @Param("noteListId") Long noteListId,
            @Param("noteProjectId") String noteProjectId);
}

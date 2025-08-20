package com.project.lay_note_was.lay_note.repository;

import com.project.lay_note_was.lay_note.entity.note_list.NoteList;
import com.project.lay_note_was.lay_note.entity.note_list_item.NoteListItem;
import com.project.lay_note_was.lay_note.entity.note_project_composition.NoteComponentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteListItemRepository extends JpaRepository<NoteListItem, Long> {
    Optional<NoteListItem> findByNoteList_NoteListId(Long noteListId);

    List<NoteListItem> findByNoteList(NoteList noteList);

    Optional<NoteListItem> findByNoteList_NoteListIdAndNoteListItemId(Long noteListId, Long noteListItemId);

    @Query("""
        SELECT nt FROM NoteListItem nt
        JOIN nt.noteList nl
        JOIN NoteProjectComposition nc
        WHERE nc.noteProject.noteProjectId = :noteProjectId
        AND nt.noteListItemId = :noteListItemId
        AND nc.noteComponentId = nl.noteListId
        AND nc.noteComponentType = :componentType
""")
    Optional<NoteListItem> findByNoteProjectIdAndNoteListItemId(
            @Param("noteProjectId") String noteProjectId,
            @Param("noteListItemId") Long noteListItemId,
            @Param("componentType") NoteComponentType componentType
    );

    Optional<NoteListItem> findAllByNoteList_NoteListId(Long noteListId);
}

package com.disqo.bestnote.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, String> {
    @Query(value = "SELECT n FROM Note n WHERE n.emailId = ?1")
    List<Note> listAllNotesByEmailId(String emailId);
}

package com.disqo.bestnote.note;

import com.disqo.bestnote.user.User;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Service
public class NoteService {

    public List<Note> getAllNotes() {
        Note note = new Note();
        note.setNote("this is a test note");
        note.setTitle("test title");
        note.setId(45454545454L);
        note.setCreateTime(Timestamp.from(Instant.EPOCH));
        User exampleUser = new User();
        exampleUser.setEmail("arpitha.example.com");
        note.setUser(exampleUser);
        return Collections.singletonList(note);
    }
}

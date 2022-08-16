package com.disqo.bestnote;

import com.disqo.bestnote.note.Note;
import com.disqo.bestnote.note.NoteRepository;
import com.disqo.bestnote.user.User;
import com.disqo.bestnote.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DataTests {
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    public void testCreateReadDelete() {
        User user = new User("user1@domain.com", "encruptedPassword", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
        Note note = new Note("title1", "note1", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()), user);
        userRepository.save(user);
        noteRepository.save(note);

        Iterable<Note> notes = noteRepository.findAll();
        Assertions.assertThat(notes).extracting(Note::getTitle).contains("title1");

        noteRepository.deleteAll();
        Assertions.assertThat(noteRepository.findAll()).isEmpty();
    }


}

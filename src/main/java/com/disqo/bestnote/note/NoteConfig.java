package com.disqo.bestnote.note;

import com.disqo.bestnote.user.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class NoteConfig {

    @Bean
    CommandLineRunner commandLineRunner(NoteRepository noteRepository) {
        return args -> {
            Note note1 = new Note("title", "note",
                    Timestamp.from(Instant.EPOCH), Timestamp.from(Instant.EPOCH));

            Note note2 = new Note("title1", "note1",
                    Timestamp.from(Instant.EPOCH), Timestamp.from(Instant.EPOCH));
            List<Note> noteList = new ArrayList<>();
            noteList.add(note1);
            noteList.add(note2);
            noteRepository.saveAllAndFlush(noteList);
        };
    }
}

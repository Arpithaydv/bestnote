package com.disqo.bestnote.user;

import com.disqo.bestnote.note.Note;
import com.disqo.bestnote.note.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserEntityRepository userEntityRepository) {
        return args -> {
            UserEntity user1 = new UserEntity("john.doe@xyz.com","passwordencruyted", Timestamp.from(Instant.EPOCH), Timestamp.from(Instant.EPOCH));
            UserEntity user2 = new UserEntity("emma.doe@xyz.com","passwordencruytedForEmma", Timestamp.from(Instant.EPOCH), Timestamp.from(Instant.EPOCH));
            List<UserEntity> userEntities = new ArrayList<>();
            userEntities.add(user1);
            userEntities.add(user2);
            userEntityRepository.saveAllAndFlush(userEntities);
        };
    }
}

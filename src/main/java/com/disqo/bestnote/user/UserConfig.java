package com.disqo.bestnote.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User user1 = new User("user1@domain.com","user1encryptedpassword", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            User user2 = new User("user2@domain.com","user2encryptedpassword", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            List<User> userEntities = new ArrayList<>();
            userEntities.add(user1);
            userEntities.add(user2);
            userRepository.saveAllAndFlush(userEntities);
        };
    }
}

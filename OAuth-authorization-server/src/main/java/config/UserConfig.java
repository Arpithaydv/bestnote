package config;

import entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User user1 = new User("user1@domain.com","$2a$12$gCEYDb.RcToUk1vFHMeyQu/3vRiA67znxcyxftNKxpd2hoSMnckRW", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            User user2 = new User("user2@domain.com","$2a$12$DHTbTn7l.3ctuoO/8B0DreRcb99yFvb6GtngiqLJ0Pt6hAmo46nZW", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            List<User> userEntities = new ArrayList<>();
            userEntities.add(user1);
            userEntities.add(user2);
            userRepository.saveAllAndFlush(userEntities);
        };
    }
}

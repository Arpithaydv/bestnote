package com.disqo.bestnote.note;

import com.disqo.bestnote.user.UserDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class NoteConfig {

    @Bean
    CommandLineRunner commandLineRunner(NoteRepository noteRepository) {
        return args -> {
            NoteDTO noteDTO1 = new NoteDTO();
            noteDTO1.setTitle("THEY’RE THE WORLD’S LARGEST LAND ANIMAL");
            noteDTO1.setNotes("The African Savanna (Bush) elephant is the world's largest land animal – with adult males, " +
                    "or bull elephants, standing up to 3m high and weighing up to 6,000kg on average. " +
                    "Males only reach their full size at 35-40 years - that’s well over half their lifespan " +
                    "as wild elephants can live for up to 60-70 years. And it’s not just the adults – " +
                    "even calves are huge! At birth, a baby elephant can weigh 120kg - that’s almost 19 stone.");
            noteDTO1.setEmailId("user1@domain.com");
            NoteDTO noteDTO2 = new NoteDTO();
            noteDTO2.setTitle("YOU CAN TELL THE THREE SPECIES APART BY THEIR EARS");
            noteDTO2.setNotes("There are three species of elephant: African Savanna (Bush), " +
                    "African Forest and Asian. The ears of African elephants are much larger " +
                    "than their cousins and are described as being shaped like the African continent, " +
                    "whereas the ears of Asian elephants are shaped like the Indian subcontinent. " +
                    "There’s also a trunk difference - " +
                    "African elephants have two ‘fingers’ at the tip of their trunks, whereas Asian elephants have one.");
            noteDTO2.setEmailId("user2@domain.com");
            noteRepository.saveAndFlush(noteDTO1.toEntity());
            noteRepository.saveAndFlush(noteDTO2.toEntity());
        };
    }
}

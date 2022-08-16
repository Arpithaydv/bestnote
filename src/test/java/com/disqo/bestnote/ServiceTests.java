package com.disqo.bestnote;

import com.disqo.bestnote.note.Note;
import com.disqo.bestnote.note.NoteRepository;
import com.disqo.bestnote.note.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @InjectMocks
    NoteService noteService;

    @Mock
    NoteRepository noteRepository;

    @Test
    public void testGetAllNotes()
    {
        List<Note> list = new ArrayList<Note>();
        Note note1 = new Note("title", "note", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
        Note note2 = new Note("title1", "note1", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
        list.add(note1);
        list.add(note2);

        when(noteRepository.findAll()).thenReturn(list);

        //test
        List<Note> noteList = noteService.getAllNotes();

        assertEquals (2, noteList.size());
        verify(noteRepository, times(1)).findAll();
    }
}

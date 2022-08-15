package com.disqo.bestnote.note;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public List<Note> getNotesByEmailId(String emailId) {
        return noteRepository.listAllNotesByEmailId(emailId);
    }

    public Note getNoteByTitle(String title){
        Optional<Note> noteOptional = noteRepository.findById(title);
        return noteOptional.orElse(null);
    }

    public Note addNewNoteForUser(Note note) {
        return noteRepository.saveAndFlush(note);
    }

    public Note updateNote(Note note) {
        return noteRepository.saveAndFlush(note);
    }

    public void deleteNote(String noteTitle) {
        noteRepository.deleteById(noteTitle);
    }
}

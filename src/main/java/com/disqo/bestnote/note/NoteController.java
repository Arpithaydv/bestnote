package com.disqo.bestnote.note;


import com.disqo.bestnote.user.User;
import com.disqo.bestnote.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path="api/v1/note")
public class NoteController {
    private final NoteService noteService;
    private final UserService userService;
    @Autowired
    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{emailId}")
    public ResponseEntity<List<Note>> getAllNotesByEmailId(@PathVariable(value = "emailId") String emailId) {
        return new ResponseEntity<>(noteService.getNotesByEmailId(emailId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody NoteDTO noteDTO) {
        try{
            if(noteDTO.getUser() == null || noteDTO.getTitle() == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            User userById = userService.getUserById(noteDTO.getUser().getEmailId());
            if(userById != null) {
                Note noteByTitle = noteService.getNoteByTitle(noteDTO.getTitle());
                if(noteByTitle != null) {
                    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
                return new ResponseEntity<>(noteService.addNewNoteForUser(noteDTO.toEntity()), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        } catch( Exception ex) {
         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody NoteDTO noteDTO) {
        try{
            if(noteDTO.getUser() == null || noteDTO.getTitle() == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            User userById = userService.getUserById(noteDTO.getUser().getEmailId());
            Note noteByTitle = noteService.getNoteByTitle(noteDTO.getTitle());
            if(Objects.equals(userById.getEmailId(), noteByTitle.getUser().getEmailId())) {
                noteByTitle.setNotes(noteDTO.getNotes());
                return new ResponseEntity<>(noteService.updateNote(noteByTitle), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete-note")
    public ResponseEntity<HttpStatus> deleteNote(@RequestParam(value="title") String noteTitle, @RequestParam(value = "emailId") String emailId) {
        try{
            Note noteByTitle = noteService.getNoteByTitle(noteTitle);
            if(noteByTitle == null || !Objects.equals(noteByTitle.getUser().getEmailId(), emailId)) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            noteService.deleteNote(noteTitle);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

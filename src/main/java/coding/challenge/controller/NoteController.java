package coding.challenge.controller;

import coding.challenge.params.Note;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
@Validated
public class NoteController {

    private static final List<Note> notes = new ArrayList<>();


    @PostMapping
    public ResponseEntity<?> createNote(@Valid @RequestBody Note note) {
        notes.add(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(note);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable("id") int id) {
        Optional<Note> optionalNote = notes.stream().filter(note -> note.getId() == id).findFirst();
        if (optionalNote.isPresent()) {
            return ResponseEntity.ok(optionalNote.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note with id = " + id + " not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNote(@PathVariable("id") int id, @Valid @RequestBody Note updatedNote, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
        }

        for (Note note : notes) {
            if (note.getId() == id) {
                note.setTitle(updatedNote.getTitle());
                note.setBody(updatedNote.getBody());
                return ResponseEntity.ok(note);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note with id = " + id + " not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") int id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                notes.remove(note);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note with id = " + id + " not found");
    }


}

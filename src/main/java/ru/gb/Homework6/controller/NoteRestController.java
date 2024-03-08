package ru.gb.Homework6.controller;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.Homework6.models.Note;
import ru.gb.Homework6.services.FileGateway;
import ru.gb.Homework6.services.NoteServices;
import ru.gb.Homework6.services.NoteServicesExtended;

import java.util.List;
import java.util.Locale;

@RestController
@AllArgsConstructor
@RequestMapping("/note")
public class NoteRestController {
    private final NoteServices noteServices;
    private final FileGateway fileGateway;

    private final NoteServicesExtended noteServicesExtended;

    /**
     * Добавление замеки
     * @return обернутая добавленная заметка
     */
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        fileGateway.writeToFile(note.getTitle() + ".txt", note.toString());
        return new ResponseEntity<>(noteServicesExtended.addNote(note), HttpStatus.CREATED);
    }

    /**
     * Получение всех заметок
     * @return обернутый список заметок
     */
    @GetMapping("")
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(noteServices.getAllNotes(),HttpStatus.OK);
    }

    /**
     * Возвращаем заметку по id
     * @param id
     * @return заметка
     */
    @GetMapping("{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        Note note=noteServices.getNoteById(id);
        if (note==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        return new ResponseEntity<Note>(note,HttpStatus.OK);
    }

    /**
     * Обновление заметки
     * @param note
     * @return
     */
    @PutMapping("")
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<Note>(noteServices.updateNote(note),HttpStatus.OK);
    }

    /**
     * Удаление заметки
     * @param id
     * @return
     */
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        noteServices.deleteNote(id);
        return ResponseEntity.ok().build();
    }



}

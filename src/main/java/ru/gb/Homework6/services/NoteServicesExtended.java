package ru.gb.Homework6.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.Homework6.models.Note;

@Service
@AllArgsConstructor
public class NoteServicesExtended {
    private final NoteServices noteServices;

    public Note addNote(Note note){
        note.setTitle(note.getTitle().substring(0, 1).toUpperCase() + note.getTitle().substring(1));
        return noteServices.addNote(note);
    }
}

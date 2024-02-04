package ru.gb.Homework6.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.Homework6.models.Note;
import ru.gb.Homework6.repository.NoteRepo;

import java.util.List;

/**
 * Сервис по заметкам
 */
@Service
@AllArgsConstructor
public class NoteServices {
    private final NoteRepo noteRepo;

    /**
     * Добавить заметку в репозиторий
     * @param note
     * @return добавленная заметка
     */
    public Note addNote(Note note){
        return noteRepo.save(note);
    }

    /**
     * Получение всех заметок
     * @return список заметок
     */
    public List<Note> getAllNotes(){
        return noteRepo.findAll();
    }

    /**
     * Получение заметки по id
     * @param id
     * @return заметка или null
     */
    public Note getNoteById(Long id){
        return noteRepo.findById(id).orElse(null);
    }

    /**
     * Обновить замтеку
     * @param note
     * @return обновленная заметка
     */
    public Note updateNote(Note note){
        Note curNote=getNoteById(note.getId());
        curNote.setContent(note.getContent());
        curNote.setTitle(note.getTitle());
        curNote.setCreateDate(note.getCreateDate());
        return noteRepo.save(curNote);
    }
    public void deleteNote(Long id){
        Note curNote=getNoteById(id);
        noteRepo.delete(curNote);
    }



}

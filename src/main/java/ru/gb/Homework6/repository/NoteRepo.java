package ru.gb.Homework6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.Homework6.models.Note;

import java.util.Optional;

/**
 * Репозиторий заметок
 */
@Repository
public interface NoteRepo extends JpaRepository<Note,Long> {
    Optional<Note> findById(Long id);
}

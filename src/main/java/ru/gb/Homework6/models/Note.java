package ru.gb.Homework6.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Структура заметки:
 * - ID (автоинкрементное)(тип - Long)
 * - Заголовок (не может быть пустым)(тип - String)
 * - Содержимое (не может быть пустым)(тип - String)
 * - Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)
 */
@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(name="create_date")
    private LocalDateTime createDate=LocalDateTime.now();
}

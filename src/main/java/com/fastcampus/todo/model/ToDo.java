package com.fastcampus.todo.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * @author Martin
 * @since 2020/12/22
 */
@Builder
@AllArgsConstructor
public class ToDo {
    Long id;
    String title;
    String description;
    String owner;
    String category;
    LocalDate dueDate;
}

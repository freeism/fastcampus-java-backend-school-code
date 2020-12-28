package com.fastcampus.todo.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Martin
 * @since 2020/12/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private String title;
    private String description;
    private String category;
    private LocalDate dueDate;
}

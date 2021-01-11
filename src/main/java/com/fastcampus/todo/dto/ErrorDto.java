package com.fastcampus.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Martin
 * @since 2021/01/11
 */
@Data
@AllArgsConstructor(staticName = "of")
public class ErrorDto {
    private String message;
}

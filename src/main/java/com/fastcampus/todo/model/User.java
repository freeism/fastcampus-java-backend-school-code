package com.fastcampus.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Martin
 * @since 2020/12/22
 */
@AllArgsConstructor
@Getter
@ToString
public class User {
    private String name;
    private String email;
}

package com.fastcampus.todo.exception;

/**
 * @author Martin
 * @since 2021/01/11
 */
public class EmailRequiredException extends RuntimeException {
    public EmailRequiredException(String message) {
        super(message);
    }
}

package com.fastcampus.todo.aop;

import com.fastcampus.todo.dto.ErrorDto;
import com.fastcampus.todo.exception.EmailRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Martin
 * @since 2021/01/11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailRequiredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleEmailRequiredException(EmailRequiredException ex) {
        return ErrorDto.of(ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleRuntimeException(RuntimeException ex) {
        System.out.println(">>> " + ex.getMessage());

//        return new ResponseEntity<>(ErrorDto.of(ex.getMessage()), HttpStatus.BAD_REQUEST);
        return ErrorDto.of(ex.getMessage());
    }
}

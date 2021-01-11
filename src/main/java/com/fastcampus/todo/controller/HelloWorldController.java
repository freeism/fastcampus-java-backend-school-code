package com.fastcampus.todo.controller;

import com.fastcampus.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Martin
 * @since 2020/12/21
 */
@RestController
@RequiredArgsConstructor
public class HelloWorldController {
    private final UserService userService;

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world";
    }

    @GetMapping("/hello-exception")
    public String helloException() {
        throw new RuntimeException("hello-exception");
    }
}


package com.fastcampus.todo.controller;

import com.fastcampus.todo.dto.UserDto;
import com.fastcampus.todo.model.User;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Martin
 * @since 2020/12/28
 */
@RestController
public class UserController {
    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable Long id) {
        return new User(id, "martin", "martin@fastcampus.com");
    }

    @PostMapping("/api/user")
    public void postUser(@RequestBody @Valid UserDto userDto) {
        System.out.println(">>>> " + userDto);
        // 저장
    }
}

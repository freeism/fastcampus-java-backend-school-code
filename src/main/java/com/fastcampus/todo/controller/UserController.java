package com.fastcampus.todo.controller;

import com.fastcampus.todo.dto.UserDto;
import com.fastcampus.todo.model.User;
import com.fastcampus.todo.repository.UserRepository;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Martin
 * @since 2020/12/28
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/api/user/{id}")       // localhost:8070/api/user/1
    public User getUser(@PathVariable Long id) {
        User user = User.emptyObject();

        user.getName();
        return userRepository.findById(id)
            .orElse(User.emptyObject());
//            .orElseThrow(() -> new RuntimeException("유저가 없습니다."));
    }

    @GetMapping("/api/user")        // localhost:8070/api/user?email=martin@fastcampus.com
    public User getUserByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }

    @PostMapping("/api/user")
    public void postUser(@RequestBody @Valid UserDto userDto) {
        User user = new User(
            null,
            userDto.getName(),
            userDto.getEmail(),
            userDto.getAddress(),
            userDto.getPassword(),
            "");

        userRepository.save(user);      // Spring Data Jpa
                                        // Hibernate EntityManager.persist();

        System.out.println(">>>> " + userDto);
        // 저장
    }
}

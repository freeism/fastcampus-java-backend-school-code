package com.fastcampus.todo.service;

import com.fastcampus.todo.model.User;
import com.fastcampus.todo.repository.TodoRepository;
import com.fastcampus.todo.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Martin
 * @since 2020/12/22
 */
@Service
@RequiredArgsConstructor
public class UserService {  // <- class name : 명사
    private final UserRepository userRepository;    // object name : 명사
    private final TodoRepository todoRepository;

    public List<User> getUsersByEmail(String email) {  // <- method name : 동사
        if (email == null) {
            throw new RuntimeException("email은 필수값입니다");
        }

        List<User> users = userRepository.findByEmail(email);   // Null-Safe

        if (users.isEmpty()) {
            users.add(new User("admin@fastcampus.com"));
        }

        return users;
    }

    // cleancode, refactoring -> 메소드의 line이 5줄을 넘으면 메소드를 나눠라.
    // -> method 10 line over -> 수정필요함

    public void modifyUser(User user) {
        user.setBloodType("A");

        userRepository.save(user);
    }

    public void removeUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

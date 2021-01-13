package com.fastcampus.todo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fastcampus.todo.model.Address;
import com.fastcampus.todo.model.User;
import com.fastcampus.todo.repository.TodoRepository;
import com.fastcampus.todo.repository.UserRepository;
import com.fastcampus.todo.service.UserService;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Martin
 * @since 2021/01/13
 */
@WebMvcTest(UserController.class)
public class UserController2Test {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private TodoRepository todoRepository;
    @MockBean
    private UserService userService;

    @Test
    void getUser() throws Exception {
        when(userRepository.findById(1L)).thenReturn(Optional.of(givenUser("martin", "martin@fastcampus.com")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.name").value("martin"))
            .andExpect(jsonPath("$.email").value("martin@fastcampus.com"));
    }

    private User givenUser(String name, String email) { // 테스트메소드 변경시켜가면서 테스트할 내용
        User user = new User(email);
        user.setId(1L);
        user.setName(name);
        user.setBloodType("A");
        user.setAddress(new Address("서울시", "성동구"));
        user.setPassword("password");

       return user;
    }
}

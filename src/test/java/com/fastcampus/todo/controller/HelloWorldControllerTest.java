package com.fastcampus.todo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fastcampus.todo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Martin
 * @since 2020/12/21
 */
@WebMvcTest
class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    void helloWorld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello-world"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("hello-world"));
    }
}

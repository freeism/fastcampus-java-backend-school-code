package com.fastcampus.todo.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fastcampus.todo.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author Martin
 * @since 2020/12/28
 */
@SpringBootTest
class UserControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void before(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
            .alwaysDo(print())
            .addFilters(new CharacterEncodingFilter("UTF-8", true))
            .build();
    }

    @DisplayName("Get유저")
    @Test
    void getUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.name").value("martin"))
            .andExpect(jsonPath("$.email").value("martin@fastcampus.com"));
    }

    @Test
    void getUserByEmail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user?email=martin@fastcampus.com"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$.[0].id").value(1L))
            .andExpect(jsonPath("$.[0].name").value("martin"))
            .andExpect(jsonPath("$.[0].email").value("martin@fastcampus.com"));
    }

    @Test
    void getUserByEmailIfThrown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user?email="))
            .andExpect(status().isBadRequest());
    }

    @DisplayName("Post유저")
    @Test

    void postUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(
                objectMapper.writeValueAsString(
                    new UserDto("martin", "martin@fastcampus.com", "seoul", "password"))))
            .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/3"))
            .andExpect(status().isOk());
    }
}

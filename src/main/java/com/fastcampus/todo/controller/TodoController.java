package com.fastcampus.todo.controller;

import com.fastcampus.todo.dto.TodoDto;
import com.fastcampus.todo.model.Todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Martin
 * @since 2020/12/28
 */
@RestController
public class TodoController {
    @GetMapping("/api/todos")
    public List<Todo> getAll() {
        List<Todo> todos = new ArrayList<>();
        Todo todo = new Todo(1L, "강의", "스프링강의", "martin", "education", LocalDate.now());

        todos.add(todo);

        return todos;
    }       /// CRUD -> DB create / read / update / delete
            /// delete -> DB x -> update (soft-delete)
            /// isDeleted() -> true : 지워졌다, false : 아직지워지지않았다.

    @GetMapping("/api/todo/{id}")
    public Todo get(@PathVariable Long id) {
        return new Todo(1L, "강의", "스프링강의", "martin", "education", LocalDate.now());
    }

    @PostMapping("/api/todo")
    public void post(@RequestBody TodoDto dto) {
        System.out.println(">>> " + dto);
        ////

        /// -> new todo() -> insert()
    }

    @PutMapping("/api/todo/{id}")
    public void put(@PathVariable Long id, @RequestBody TodoDto dto) {
        System.out.println(">>> " + dto);
        ////

        /// -> id -> getTodo().setDto() -> update()
    }

    @PatchMapping("/api/todo/{id}/completed")
    public void patch(@PathVariable Long id) {
        /// -> id -> getTodo().setComplete() -> update()
    }
}

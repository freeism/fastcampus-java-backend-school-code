package com.fastcampus.todo.repository;

import com.fastcampus.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Martin
 * @since 2021/01/06
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}

package com.fastcampus.todo.repository;

import com.fastcampus.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Martin
 * @since 2020/12/30
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

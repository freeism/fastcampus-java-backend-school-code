package com.fastcampus.todo.repository;

import com.fastcampus.todo.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Martin
 * @since 2020/12/30
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);

    @Query("select u from User u where u.email = :mail and u.bloodType = :bloodType")
    List<User> findByMailAndBloodType(@Param("mail") String mail, @Param("bloodType") String bloodType);

    // query -> 1) native query, 2) jpql

    // 1) @Query

    // 2) 3rd-party library
    // QueryDsl, Jooq, ...
}

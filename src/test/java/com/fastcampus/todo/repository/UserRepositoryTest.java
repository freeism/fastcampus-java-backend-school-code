package com.fastcampus.todo.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.fastcampus.todo.model.Address;
import com.fastcampus.todo.model.User;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Martin
 * @since 2021/01/13
 */
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {   // create-read-update-delete
        givenUser("martin", "martin@fastcampus.com");

        List<User> results = userRepository.findAll();
        User result = results.get(1);

        assertThat(result.getName()).isEqualTo("martin");
        assertThat(result.getEmail()).isEqualTo("martin@fastcampus.com");
    }

    @Test
    void findByEmail() {
        // given
        givenUser("martin", "martin@fastcampus.com");

        // when
        List<User> results = userRepository.findByEmail("martin@fastcampus.com");

        // then
        assertThat(results.size()).isEqualTo(2);
    }

    private void givenUser(String name, String email) { // 테스트메소드 변경시켜가면서 테스트할 내용
        User user = new User(email);
        user.setName(name);
        user.setBloodType("A");
        user.setAddress(new Address("서울시", "성동구"));
        user.setPassword("password");

        userRepository.save(user);
    }
}

package com.fastcampus.todo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fastcampus.todo.model.User;
import com.fastcampus.todo.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Martin
 * @since 2021/01/08
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks    // mock을 주입할 target class
    private UserService userService;
    @Mock   // 생성할 mock
    private UserRepository userRepository;

    @Test
    void getUsersByEmail() {
        when(userRepository.findByEmail("martin@fastcampus.com"))
            .thenReturn(mockUsers());

//        doReturn(mockUsers()).when(userRepository).findByEmail("martin@fastcampus.com");

        List<User> result = userService.getUsersByEmail("martin@fastcampus.com");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getEmail()).isEqualTo("martin@fastcampus.com");
    }

    @Test
    void getUsersByEmailIfEmpty() {
        when(userRepository.findByEmail("martin@fastcampus.com"))
            .thenReturn(new ArrayList<>());

        List<User> result = userService.getUsersByEmail("martin@fastcampus.com");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getEmail()).isEqualTo("admin@fastcampus.com");
    }

    @Test
    void getUsersByEmailIfNull() {
        assertThrows(RuntimeException.class, () -> userService.getUsersByEmail(null));
    }

    @Test
    void modifyUser() {
        User user = new User();
        user.setId(1L);

        userService.modifyUser(user);

        verify(userRepository, times(1)).save(argThat(new IsBloodTypeA()));
//        verify(userRepository, times(1)).save(any());
    }

    @Test
    void removeUser() {
//        doNothing().when(userRepository).deleteById(1L);

        userService.removeUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }

    private List<User> mockUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("martin@fastcampus.com"));

        return users;
    }

    private static class IsBloodTypeA implements ArgumentMatcher<User> {
        @Override
        public boolean matches(User argument) {
//            return argument != null
//                && argument.getBloodType() != null
//                && argument.getBloodType().equals("A");

            return argument != null && "A".equals(argument.getBloodType());
        }
    }
}

package ua.nure.calendar.services.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.nure.calendar.persistent.authentication.AuthenticationDao;
import ua.nure.calendar.persistent.user.UserDao;
import ua.nure.calendar.persistent.user.UserEntity;
import ua.nure.calendar.services.user.InvalidCredentials;
import ua.nure.calendar.services.user.UserAuthenticationResponse;
import ua.nure.calendar.services.user.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService userService;
    private UserDao mockUserDao;
    private AuthenticationDao mockAuthDao;

    @BeforeEach
    void setUp() {
        mockUserDao = mock(UserDao.class);
        mockAuthDao = mock(AuthenticationDao.class);
        userService = new UserService(mockUserDao, mockAuthDao);
    }

    @Test
    void testAuthSuccess() throws InvalidCredentials {
        String email = "test@example.com";
        String password = "password123";

        when(mockUserDao.findByEmail(email))
                .thenReturn(java.util.Optional.of(new UserEntity("1", "John", "Doe", email, StringEncryptor.encrypt(password), false, false)));
        UserAuthenticationResponse response = userService.auth(email, password);

        assertEquals("1", response.authenticationToken());

        verify(mockAuthDao, times(1)).create(any());
    }

    @Test
    void testAuthFailure() {
        String email = "test@example.com";
        String password = "password123";

        when(mockUserDao.findByEmail(email)).thenReturn(java.util.Optional.empty());

        assertThrows(InvalidCredentials.class, () -> userService.auth(email, password));

        verify(mockAuthDao, never()).create(any());
    }

    @Test
    void testAuthFailureInvalidPassword() {
        String email = "test@example.com";
        String password = "password123";

        when(mockUserDao.findByEmail(email))
                .thenReturn(java.util.Optional.of(new UserEntity("1", "John", "Doe", email, "incorrectpassword", false, false)));

        assertThrows(InvalidCredentials.class, () -> userService.auth(email, password));

        verify(mockAuthDao, never()).create(any());
    }
}
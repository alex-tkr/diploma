package ua.nure.calendar.services.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import ua.nure.calendar.persistent.authentication.AuthenticationDao;
import ua.nure.calendar.persistent.authentication.AuthenticationEntity;
import ua.nure.calendar.persistent.user.UserDao;
import ua.nure.calendar.persistent.user.UserEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static ua.nure.calendar.services.user.StringEncryptor.encrypt;

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
                .thenReturn(java.util.Optional.of(new UserEntity("1", "John", "Doe", email, encrypt(password), false, false)));
        ArgumentCaptor<AuthenticationEntity> authCaptor = ArgumentCaptor.forClass(AuthenticationEntity.class);

        UserAuthenticationResponse response = userService.auth(email, password);

        verify(mockAuthDao).create(authCaptor.capture());
        assertEquals(authCaptor.getValue().token(), response.authenticationToken());

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

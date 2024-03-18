package ua.nure.calendar.services.user;

import ua.nure.calendar.persistent.authentication.AuthenticationDao;
import ua.nure.calendar.persistent.authentication.AuthenticationEntity;
import ua.nure.calendar.persistent.user.UserDao;
import ua.nure.calendar.persistent.user.UserEntity;
import ua.nure.calendar.services.DataNotFound;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import static java.lang.String.format;
import static java.time.temporal.ChronoUnit.DAYS;

public class UserService {

    private final UserDao userDao;
    private final AuthenticationDao authDao;

    public UserService(UserDao userDao, AuthenticationDao authDao) {
        this.userDao = userDao;
        this.authDao = authDao;
    }

    public String register(String firstName,
                           String lastName,
                           String email,
                           String password,
                           boolean isTeacher,
                           boolean isAdmin)
            throws UserAlreadyExist {

        var foundUser = userDao.findByEmail(email);
        if (foundUser.isPresent()) {
            throw new UserAlreadyExist(format("User with email `%s` already exist.", email));
        }

        var newUser = new UserEntity(
                UUID.randomUUID().toString(),
                firstName,
                lastName,
                email,
                StringEncryptor.encrypt(password),
                isTeacher,
                isAdmin
        );

        userDao.create(newUser);

        return newUser.id();
    }

    public AuthenticationEntity auth(String email, String password) throws InvalidCredentials {
        var user = userDao.findByEmail(email);
        if (user.isEmpty() || !user.get().password().equals(StringEncryptor.encrypt(password))) {
            throw new InvalidCredentials("User with provided credentials doesn't exist or password do not match.");
        }

        var authentication = new AuthenticationEntity(
                UUID.randomUUID().toString(),
                user.get().id(),
                UUID.randomUUID().toString(),
                Date.valueOf(LocalDate.now().plus(3, DAYS))
        );

        authDao.create(authentication);

        return authentication;
    }

    public UserEntity profileById(String userId) throws DataNotFound {
        var user = userDao.findById(userId);
        if(user.isEmpty()) {
            throw new DataNotFound("User with provided ID doesn't exist");
        }

        return user.get();
    }
}

package ua.nure.calendar.persistent.user;

import ua.nure.calendar.persistent.DataAccessObject;

import java.util.Optional;

/**
 * {@link DataAccessObject} which is intended to work with user.
 */
public interface UserDao extends DataAccessObject<UserEntity> {

    /**
     * Finds {@link UserEntity} by login.
     *
     * @param login The user login.
     * @return Optional founded {@link UserEntity}.
     */
    Optional<UserEntity> findByLogin(String login);
}

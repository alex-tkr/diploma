package ua.nure.calendar.persistent.user;

import ua.nure.calendar.persistent.DataAccessObject;

import java.util.Optional;

/**
 * {@link DataAccessObject} which is intended to work with user.
 */
public interface UserDao extends DataAccessObject<UserEntity> {

    /**
     * Finds {@link UserEntity} by email.
     *
     * @param email The user email.
     * @return Optional founded {@link UserEntity}.
     */
    Optional<UserEntity> findByEmail(String email);
}

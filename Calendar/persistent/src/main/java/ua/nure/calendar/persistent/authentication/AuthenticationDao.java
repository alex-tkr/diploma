package ua.nure.calendar.persistent.authentication;

import ua.nure.calendar.persistent.DataAccessObject;

import java.util.Optional;

public interface AuthenticationDao extends DataAccessObject<AuthenticationEntity> {

    /**
     * Finds {@link AuthenticationEntity} by token.
     *
     * @param token The authentication token.
     * @return Optional founded {@link AuthenticationEntity}.
     */
    Optional<AuthenticationEntity> findByToken(String token);

}

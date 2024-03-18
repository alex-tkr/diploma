package ua.nure.calendar.services.user;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * Server response which is intended to store
 * information about the user authentication.
 */
public class UserAuthenticationResponse {

    private final String authenticationToken;

    public UserAuthenticationResponse(String authenticationToken) {
        checkNotNull(authenticationToken);
        checkState(!authenticationToken.isEmpty());

        this.authenticationToken = authenticationToken;
    }

    public String authenticationToken() {
        return authenticationToken;
    }
}

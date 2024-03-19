package ua.nure.calendar.services.event;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class EventAuthenticationResponse {

    private final String authenticationToken;

    public EventAuthenticationResponse(String authenticationToken) {
        checkNotNull(authenticationToken);
        checkState(!authenticationToken.isEmpty());

        this.authenticationToken = authenticationToken;
    }

    public String authenticationToken() {
        return authenticationToken;
    }
}

package ua.nure.calendar.web.api;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import spark.Response;
import ua.nure.calendar.services.user.InvalidCredentials;
import ua.nure.calendar.services.user.UserService;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * An abstract implementation of {@link WrappedRoute} with authorization feature.
 * Authorization provides the user id by token, if there is one in the system.
 */
public abstract class AuthorizedUserRoute extends WrappedRoute {

    private final UserService userService;

    public AuthorizedUserRoute(UserService userService) {
        this.userService = checkNotNull(userService);
    }

    @Override
    protected final void wrappedRequestHandle(WrappedRequest request, Response response)
            throws JsonEntityValidationException {
        checkNotNull(request, response);
        String authorizationHeader = request.headers("Authorization");
        String token = Iterables.get(Splitter.on(' ')
                .split(authorizationHeader), 1);

        String userId = null;
        try {
            userId = userService.verifyToken(token);
        } catch (InvalidCredentials e) {
            response.status(403);
            response.body(e.getMessage());
        }

        authorizedHandle(request, response, userId);
    }

    protected abstract void authorizedHandle(WrappedRequest request,
                                             Response response,
                                             String userId) throws JsonEntityValidationException;
}

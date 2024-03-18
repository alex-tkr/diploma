package ua.nure.calendar.web.api.user;

import com.google.gson.Gson;
import spark.Response;
import ua.nure.calendar.services.user.InvalidCredentials;
import ua.nure.calendar.services.user.UserService;
import ua.nure.calendar.web.api.JsonEntityValidationException;
import ua.nure.calendar.web.api.WrappedRequest;
import ua.nure.calendar.web.api.WrappedRoute;

public class SignInRoute extends WrappedRoute {

    private final Gson gson = new Gson();
    private final UserService userService;

    public SignInRoute(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void wrappedRequestHandle(WrappedRequest request, Response response) throws JsonEntityValidationException {
        var body = request.jsonBody();
        try {
            var authResponse = userService.auth(body.getAsString("email"), body.getAsString("password"));
            response.body(gson.toJson(authResponse));
        } catch (InvalidCredentials e) {
            response.status(403);
        }
    }
}

package ua.nure.calendar.web.api.user;

import com.google.gson.Gson;
import spark.Response;
import ua.nure.calendar.services.user.UserAlreadyExist;
import ua.nure.calendar.services.user.UserService;
import ua.nure.calendar.web.api.JsonEntityValidationException;
import ua.nure.calendar.web.api.WrappedRequest;
import ua.nure.calendar.web.api.WrappedRoute;

public class RegisterRoute extends WrappedRoute {
    private final Gson gson = new Gson();
    private final UserService userService;

    public RegisterRoute(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void wrappedRequestHandle(WrappedRequest request, Response response) throws JsonEntityValidationException {
        var body = request.jsonBody();
        try {
            var registerResponse = userService.register(body.getAsString("firstName"),
                    body.getAsString("lastName"),
                    body.getAsString("email"),
                    body.getAsString("password"),
                    body.getAsBoolean("isAdmin"),
                    body.getAsBoolean("isTeacher"));
            response.body(gson.toJson(registerResponse));
        } catch (UserAlreadyExist e) {
            response.status(403);
        }
    }
}

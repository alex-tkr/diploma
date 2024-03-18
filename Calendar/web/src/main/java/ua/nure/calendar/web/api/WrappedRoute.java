package ua.nure.calendar.web.api;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class WrappedRoute implements Route {

    @Override
    public final String handle(Request request, Response response) {
        checkNotNull(request);
        checkNotNull(response);

        try {

            WrappedRequest wrappedRequest = new WrappedRequest(request);
            wrappedRequestHandle(wrappedRequest, response);

            return Optional.ofNullable(response.body())
                    .orElse("");

        }
        catch (JsonEntityValidationException exception) {
            response.status(400);

            return exception.getMessage();
        }
        catch (Exception exception) {

            exception.printStackTrace();

            return exception.getMessage();
        }
    }

    protected abstract void wrappedRequestHandle(WrappedRequest request, Response response) throws JsonEntityValidationException;
}

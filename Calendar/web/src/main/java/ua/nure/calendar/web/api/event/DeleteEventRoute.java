package ua.nure.calendar.web.api.event;

import com.google.gson.Gson;
import spark.Response;
import ua.nure.calendar.services.AccessForbidden;
import ua.nure.calendar.services.DataNotFound;
import ua.nure.calendar.services.event.EventService;
import ua.nure.calendar.web.api.JsonEntityValidationException;
import ua.nure.calendar.web.api.WrappedRequest;
import ua.nure.calendar.web.api.WrappedRoute;

public class DeleteEventRoute extends WrappedRoute {
    private final Gson gson = new Gson();
    private final EventService eventService;
    public DeleteEventRoute(EventService eventService) {
        this.eventService = eventService;
    }
    @Override
    protected void wrappedRequestHandle(WrappedRequest request, Response response) throws JsonEntityValidationException {
        var body = request.jsonBody();
        try {
            eventService.deleteEvent(body.getAsString("idUser"), body.getAsString("idEvent"));

        } catch (DataNotFound | AccessForbidden e) {
            response.status(403);
        }
    }
}

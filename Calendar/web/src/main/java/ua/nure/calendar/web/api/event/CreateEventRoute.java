package ua.nure.calendar.web.api.event;

import com.google.gson.Gson;
import spark.Response;
import ua.nure.calendar.services.event.EventService;
import ua.nure.calendar.web.api.JsonEntityValidationException;
import ua.nure.calendar.web.api.WrappedRequest;
import ua.nure.calendar.web.api.WrappedRoute;

import java.sql.Date;

public class CreateEventRoute extends WrappedRoute {
    private final Gson gson = new Gson();
    private final EventService eventService;
    public CreateEventRoute(EventService eventService) {
        this.eventService = eventService;
    }


    @Override
    protected void wrappedRequestHandle(WrappedRequest request, Response response) throws JsonEntityValidationException {
        var body = request.jsonBody();
        var createEventResponse = eventService.createEvent(body.getAsDate("eventDate"), body.getAsString("name"), body.getAsString("description"), body.getAsTime("startTime"), body.getAsTime("endTime"), body.getAsDouble("price"), body.getAsString("idAuthor"));
        response.body(gson.toJson(createEventResponse));
    }
}

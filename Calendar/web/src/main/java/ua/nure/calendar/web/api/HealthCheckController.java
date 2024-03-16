package ua.nure.calendar.web.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HealthCheckController {

    @Get("/health-check")
    public HttpResponse<?> healthCheck() {
        return HttpResponse
                .status(HttpStatus.OK)
                .body("OK");
    }
}

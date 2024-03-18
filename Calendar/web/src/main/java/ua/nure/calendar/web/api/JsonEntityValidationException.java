package ua.nure.calendar.web.api;

/**
 * The {@link Exception} that is thrown if the JSON object is invalid.
 */
public class JsonEntityValidationException extends Exception {
    public JsonEntityValidationException(String message) {
        super(message);
    }
}

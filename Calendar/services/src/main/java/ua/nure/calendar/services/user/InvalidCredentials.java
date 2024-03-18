package ua.nure.calendar.services.user;

public class InvalidCredentials extends Exception {
    public InvalidCredentials(String message) {
        super(message);
    }
}

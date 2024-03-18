package ua.nure.calendar.services.user;

public class UserAlreadyExist extends Exception {
    public UserAlreadyExist(String message) {
        super(message);
    }
}

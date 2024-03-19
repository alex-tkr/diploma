package ua.nure.calendar.services;

public class AccessForbidden extends Exception{
    public AccessForbidden(String message) {
        super(message);
    }
}

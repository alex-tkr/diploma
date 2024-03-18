package ua.nure.calendar.persistent.authentication;

import ua.nure.calendar.persistent.Entity;

import java.sql.Date;

public class AuthenticationEntity extends Entity {
    private final String idUser;
    private final String token;
    private final Date expirationDate;

    public AuthenticationEntity(String idAuthentication, String idUser, String token, Date expirationDate) {
        super(idAuthentication);
        this.idUser = idUser;
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public String idUser() {
        return idUser;
    }

    public String token() {
        return token;
    }

    public Date expirationDate() {
        return expirationDate;
    }
}

package ua.nure.calendar.persistent.user;

import ua.nure.calendar.persistent.Entity;

public class UserEntity extends Entity {

    private final String login;
    private final String password;

    public UserEntity(int id, String login, String password) {
        super(id);
        this.login = login;
        this.password = password;
    }

    public String login() {
        return login;
    }

    public String password() {
        return password;
    }
}

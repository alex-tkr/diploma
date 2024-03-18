package ua.nure.calendar.persistent.user;

import ua.nure.calendar.persistent.Entity;

public class UserEntity extends Entity {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final boolean isAdmin;
    private final boolean isTeacher;

    public UserEntity(String idUser,
                      String firstName,
                      String lastName,
                      String email,
                      String password,
                      boolean isAdmin,
                      boolean isTeacher) {
        super(idUser);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isTeacher = isTeacher;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isTeacher() {
        return isTeacher;
    }
}

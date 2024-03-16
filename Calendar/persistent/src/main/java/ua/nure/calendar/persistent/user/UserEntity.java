package ua.nure.calendar.persistent.user;

import ua.nure.calendar.persistent.Entity;

public class UserEntity extends Entity {

    private final String firstName;
    private final String LastName;
    private final String email;
    private final String password;
    private final int idUserRole;

    public UserEntity(int id,
                      String firstName,
                      String lastName,
                      String email,
                      String password,
                      int idUserRole) {
        super(id);
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.password = password;
        this.idUserRole = idUserRole;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return LastName;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    public int idUserRole() {
        return idUserRole;
    }
}

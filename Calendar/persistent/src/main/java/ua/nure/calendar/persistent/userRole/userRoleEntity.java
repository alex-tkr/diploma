package ua.nure.calendar.persistent.userRole;

import ua.nure.calendar.persistent.Entity;

public class userRoleEntity extends Entity {
    String roleName;
    public userRoleEntity(int idUserRole) {
        super(idUserRole);
        this.roleName = roleName;
    }
    public String roleName() {
        return roleName;
    }
}
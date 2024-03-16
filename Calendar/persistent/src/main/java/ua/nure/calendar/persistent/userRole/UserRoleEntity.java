package ua.nure.calendar.persistent.userRole;

import ua.nure.calendar.persistent.Entity;

public class UserRoleEntity extends Entity {
    private final String roleName;
    public UserRoleEntity(String idUserRole, String roleName) {
        super(idUserRole);
        this.roleName = roleName;
    }
    public String roleName() {
        return roleName;
    }
}
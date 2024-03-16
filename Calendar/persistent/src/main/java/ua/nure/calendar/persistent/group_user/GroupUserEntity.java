package ua.nure.calendar.persistent.group_user;

import ua.nure.calendar.persistent.Entity;

public class GroupUserEntity extends Entity {

    private final int idGroup;
    private final int User;
    public GroupUserEntity(int idGroupUser, int idGroup, int user) {
        super(idGroupUser);
        this.idGroup = idGroup;
        User = user;
    }

    public int idGroup() {
        return idGroup;
    }
    public int User() {
        return User;
    }
}

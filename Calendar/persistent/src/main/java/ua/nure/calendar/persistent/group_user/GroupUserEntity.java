package ua.nure.calendar.persistent.group_user;

import ua.nure.calendar.persistent.Entity;

public class GroupUserEntity extends Entity {

    private final String idGroup;
    private final String idUser;
    public GroupUserEntity(String idGroupUser, String idGroup, String idUser) {
        super(idGroupUser);
        this.idGroup = idGroup;
        this.idUser = idUser;
    }

    public String idGroup() {
        return idGroup;
    }
    public String idUser() {
        return idUser;
    }
}

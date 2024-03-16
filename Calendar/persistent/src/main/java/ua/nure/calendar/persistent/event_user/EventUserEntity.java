package ua.nure.calendar.persistent.event_user;

import ua.nure.calendar.persistent.Entity;

public class EventUserEntity extends Entity {
    private int idUser;
    private int idEvent;
    public EventUserEntity(int idEventUser) {
        super(idEventUser);
        this.idUser = idUser;
        this.idEvent = idEvent;
    }
    public int idUser() {
        return idUser;
    }

    public int idEvent() {
        return idEvent;
    }
}

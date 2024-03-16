package ua.nure.calendar.persistent.event_user;

import ua.nure.calendar.persistent.Entity;

public class EventUserEntity extends Entity {
    private String idUser;
    private String idEvent;
    public EventUserEntity(String idEventUser,String idEvent, String idUser) {
        super(idEventUser);
        this.idUser = idUser;
        this.idEvent = idEvent;
    }
    public String idUser() {
        return idUser;
    }

    public String idEvent() {
        return idEvent;
    }
}

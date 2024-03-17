package ua.nure.calendar.persistent.event_user;

import ua.nure.calendar.persistent.Entity;

public class EventUserEntity extends Entity {
    private final String idUser;
    private final String idEvent;

    private final boolean isPaid;

    public EventUserEntity(String idEventUser, String idEvent, String idUser, boolean isPaid) {
        super(idEventUser);
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.isPaid = isPaid;
    }
    public String idUser() {
        return idUser;
    }

    public String idEvent() {
        return idEvent;
    }

    public boolean isPaid() {
        return isPaid;
    }
}

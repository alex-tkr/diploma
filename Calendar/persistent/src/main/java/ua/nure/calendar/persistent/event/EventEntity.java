package ua.nure.calendar.persistent.event;

import ua.nure.calendar.persistent.Entity;

import java.sql.Date;
import java.sql.Time;

public class EventEntity extends Entity {
    private final Date eventDate;
    private final String name;
    private final String description;
    private final Time startTime;
    private final Time endTime;
    public EventEntity(String idEvent, Date eventDate, String name, String description, Time startTime, Time endTime) {
        super(idEvent);
        this.eventDate = eventDate;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Date eventDate() {
        return eventDate;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public Time startTime() {
        return startTime;
    }

    public Time endTime() {
        return endTime;
    }
}

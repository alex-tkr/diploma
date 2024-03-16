package ua.nure.calendar.persistent.event;

import ua.nure.calendar.persistent.Entity;

public class EventEntity extends Entity {
    private String eventDate;
    private String name;
    private String description;
    private String startTime;
    private String endTime;
    public EventEntity(int idEvent) {
        super(idEvent);
        this.eventDate = eventDate;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String eventDate() {
        return eventDate;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public String startTime() {
        return startTime;
    }

    public String endTime() {
        return endTime;
    }
}

package ua.nure.calendar.persistent;

public class EventEntity extends Entity {
    String eventDate;
    String name;
    String description;
    String startTime;
    String endTime;
    public EventEntity(int idEvent) {
        super(idEvent);
        this.eventDate;
        this.name;
        this.description;
        this.startTime;
        this.endTime;
    }
}

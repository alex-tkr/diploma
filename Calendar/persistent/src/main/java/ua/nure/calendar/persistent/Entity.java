package ua.nure.calendar.persistent;

public abstract class Entity {
    private final String id;

    public Entity(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}

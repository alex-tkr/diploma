package ua.nure.calendar.persistent;

public abstract class Entity {
    private final int id;

    public Entity(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}

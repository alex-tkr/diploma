package ua.nure.calendar.persistent.homework;

import ua.nure.calendar.persistent.Entity;

public class HomeworkEntity extends Entity {
    private final int idUser;
    private final int mark;
    private final String description;

    public HomeworkEntity(int idHomework, int idUser, int mark, String description) {
        super(idHomework);
        this.idUser = idUser;
        this.mark = mark;
        this.description = description;
    }

    public int idUser() {
        return idUser;
    }

    public int mark() {
        return mark;
    }
    public String description() {
        return description;
    }
}

package ua.nure.calendar.persistent.homework;

import ua.nure.calendar.persistent.Entity;

public class HomeworkEntity extends Entity {
    private final String idUser;
    private final int mark;
    private final String description;

    public HomeworkEntity(String idHomework, String idUser, int mark, String description) {
        super(idHomework);
        this.idUser = idUser;
        this.mark = mark;
        this.description = description;
    }

    public String idUser() {
        return idUser;
    }

    public int mark() {
        return mark;
    }
    public String description() {
        return description;
    }
}

package ua.nure.calendar.persistent.group;

import ua.nure.calendar.persistent.Entity;

public class GroupEntity extends Entity {

    private final String idTeacher;
    private final int grade;

    public GroupEntity(String idGroup,
                       String idTeacher,
                      int grade) {
        super(idGroup);
        this.idTeacher = idTeacher;
        this.grade = grade;
    }

    public String idTeacher() {
        return idTeacher;
    }

    public int grade() {
        return grade;
    }
}
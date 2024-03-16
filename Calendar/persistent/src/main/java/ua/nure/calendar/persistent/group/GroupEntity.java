package ua.nure.calendar.persistent.group;

import ua.nure.calendar.persistent.Entity;

public class GroupEntity extends Entity {

    private final int idTeacher;
    private final int grade;

    public GroupEntity(int idGroup,
                      int idTeacher,
                      int grade) {
        super(idGroup);
        this.idTeacher = idTeacher;
        this.grade = grade;
    }

    public int idTeacher() {
        return idTeacher;
    }

    public int grade() {
        return grade;
    }
}
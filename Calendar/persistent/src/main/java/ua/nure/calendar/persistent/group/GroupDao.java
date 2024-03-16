package ua.nure.calendar.persistent.group;

import ua.nure.calendar.persistent.DataAccessObject;

import java.util.Optional;

public interface GroupDao extends DataAccessObject<GroupEntity> {
    Optional<GroupEntity> findByGrade(int grade);

}

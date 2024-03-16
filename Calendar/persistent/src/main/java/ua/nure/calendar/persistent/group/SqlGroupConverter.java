package ua.nure.calendar.persistent.group;

import ua.nure.calendar.persistent.SqlEntityConverter;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

public class SqlGroupConverter implements SqlEntityConverter<GroupEntity> {
    private final String table;

    SqlGroupConverter(String table) {
        this.table = checkNotNull(table);
    }

    @Override
    public GroupEntity resultSetToEntity(@Nonnull ResultSet resultSet) {
        checkNotNull(resultSet);

        try {
            return new GroupEntity(
                    resultSet.getString("idGroup"),
                    resultSet.getString("idTeacher"),
                    resultSet.getInt("grade"));
        } catch (SQLException e) {
            throw new RuntimeException("Result set reading failed.", e);
        }
    }

    @Override
    public String entityInsertSql(@Nonnull GroupEntity entity) {
        checkNotNull(entity);

        return String.format("INSERT INTO %s (idGroup, idTeacher, grade)" +
                        "VALUES('%s','%s','%s')",
                table,
                entity.id(),
                entity.idTeacher(),
                entity.grade());
    }

    @Override
    public String entityUpdateSql(@Nonnull GroupEntity entity) {
        checkNotNull(entity);

        return String.format("UPDATE %s " +
                        "SET " +
                        "idTeacher = '%s', " +
                        "grade = '%s', " +
                        "WHERE idGroup = '%s'",
                table,
                entity.id(),
                entity.idTeacher(),
                entity.grade());
    }
}

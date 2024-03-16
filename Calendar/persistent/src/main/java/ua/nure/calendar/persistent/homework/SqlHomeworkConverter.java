package ua.nure.calendar.persistent.homework;

import ua.nure.calendar.persistent.SqlEntityConverter;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

public class SqlHomeworkConverter implements SqlEntityConverter<HomeworkEntity> {
    private final String table;

    SqlHomeworkConverter(String table) {
        this.table = checkNotNull(table);
    }

    @Override
    public HomeworkEntity resultSetToEntity(@Nonnull ResultSet resultSet) {
        checkNotNull(resultSet);

        try {
            return new HomeworkEntity(
                    resultSet.getString("idHomework"),
                    resultSet.getString("idUser"),
                    resultSet.getInt("mark"),
                    resultSet.getString("description"));
        } catch (SQLException e) {
            throw new RuntimeException("Result set reading failed.", e);
        }
    }

    @Override
    public String entityInsertSql(@Nonnull HomeworkEntity entity) {
        checkNotNull(entity);

        return String.format("INSERT INTO %s (idHomework, idUser, mark, description)" +
                        "VALUES('%s','%s','%s','%s')",
                table,
                entity.id(),
                entity.idUser(),
                entity.mark(),
                entity.description());
    }

    @Override
    public String entityUpdateSql(@Nonnull HomeworkEntity entity) {
        checkNotNull(entity);

        return String.format("UPDATE %s " +
                        "SET " +
                        "idUser = '%s', " +
                        "mark = '%s', " +
                        "description = '%s', " +
                        "WHERE idHomework = '%s'",
                table,
                entity.id(),
                entity.idUser(),
                entity.mark(),
                entity.description());
    }
}

package ua.nure.calendar.persistent.event;

import ua.nure.calendar.persistent.SqlEntityConverter;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

public class SqlEventConverter implements SqlEntityConverter<EventEntity> {
    private final String table;

    SqlEventConverter(String table) {
        this.table = checkNotNull(table);
    }

    @Override
    public EventEntity resultSetToEntity(@Nonnull ResultSet resultSet) {
        checkNotNull(resultSet);

        try {
            return new EventEntity(
                    resultSet.getString("idEvent"),
                    resultSet.getDate("eventDate"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getTime("startTime"),
                    resultSet.getTime("endTime"));
        } catch (SQLException e) {
            throw new RuntimeException("Result set reading failed.", e);
        }
    }

    @Override
    public String entityInsertSql(@Nonnull EventEntity entity) {
        checkNotNull(entity);

        return String.format("INSERT INTO %s (idEvent, eventDate, name, description, startTime, endTime)" +
                        "VALUES('%s','%s','%s','%s','%s','%s')",
                table,
                entity.id(),
                entity.eventDate(),
                entity.name(),
                entity.description(),
                entity.startTime(),
                entity.endTime());
    }

    @Override
    public String entityUpdateSql(@Nonnull EventEntity entity) {
        checkNotNull(entity);

        return String.format("UPDATE %s " +
                        "SET " +
                        "eventDate = '%s', " +
                        "name = '%s', " +
                        "description = '%s', " +
                        "startTime = '%s'" +
                        "endTime = '%s'" +
                        "WHERE idEvent = '%s'",
                table,
                entity.id(),
                entity.eventDate(),
                entity.name(),
                entity.description(),
                entity.startTime(),
                entity.endTime());
    }
}

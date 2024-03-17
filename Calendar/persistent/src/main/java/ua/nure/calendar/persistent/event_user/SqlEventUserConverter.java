package ua.nure.calendar.persistent.event_user;

import ua.nure.calendar.persistent.SqlEntityConverter;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

public class SqlEventUserConverter implements SqlEntityConverter<EventUserEntity> {
    private final String table;

    SqlEventUserConverter(String table) {
        this.table = checkNotNull(table);
    }

    @Override
    public EventUserEntity resultSetToEntity(@Nonnull ResultSet resultSet) {
        checkNotNull(resultSet);

        try {
            return new EventUserEntity(
                    resultSet.getString("idEventUser"),
                    resultSet.getString("idUser"),
                    resultSet.getString("idEvent"),
                    resultSet.getBoolean("isPaid"));
        } catch (SQLException e) {
            throw new RuntimeException("Result set reading failed.", e);
        }
    }

    @Override
    public String entityInsertSql(@Nonnull EventUserEntity entity) {
        checkNotNull(entity);

        return String.format("INSERT INTO %s (idEventUser, idUser, idEvent, isPaid)" +
                        "VALUES('%s','%s','%s','%s')",
                table,
                entity.id(),
                entity.idUser(),
                entity.idEvent(),
                entity.isPaid());
    }

    @Override
    public String entityUpdateSql(@Nonnull EventUserEntity entity) {
        checkNotNull(entity);

        return String.format("UPDATE %s " +
                        "SET " +
                        "idUser = '%s', " +
                        "idEvent = '%s', " +
                        "isPaid = '%s', " +
                        "WHERE idEventUser = '%s'",
                table,
                entity.id(),
                entity.idUser(),
                entity.idEvent(),
                entity.isPaid());
    }
}

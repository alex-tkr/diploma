package ua.nure.calendar.persistent.group_user;

import ua.nure.calendar.persistent.SqlEntityConverter;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

public class SqlGroupUserConverter implements SqlEntityConverter<GroupUserEntity> {
    private final String table;

    SqlGroupUserConverter(String table) {
        this.table = checkNotNull(table);
    }

    @Override
    public GroupUserEntity resultSetToEntity(@Nonnull ResultSet resultSet) {
        checkNotNull(resultSet);

        try {
            return new GroupUserEntity(
                    resultSet.getString("idGroupUser"),
                    resultSet.getString("idUser"),
                    resultSet.getString("idGroup"));
        } catch (SQLException e) {
            throw new RuntimeException("Result set reading failed.", e);
        }
    }

    @Override
    public String entityInsertSql(@Nonnull GroupUserEntity entity) {
        checkNotNull(entity);

        return String.format("INSERT INTO %s (idGroupUser, idUser, idGroup)" +
                        "VALUES('%s','%s','%s')",
                table,
                entity.id(),
                entity.idUser(),
                entity.idGroup());
    }

    @Override
    public String entityUpdateSql(@Nonnull GroupUserEntity entity) {
        checkNotNull(entity);

        return String.format("UPDATE %s " +
                        "SET " +
                        "idUser = '%s', " +
                        "idGroup = '%s', " +
                        "WHERE idGroupUser = '%s'",
                table,
                entity.idUser(),
                entity.idGroup(),
                entity.id());
    }
}

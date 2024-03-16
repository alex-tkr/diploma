package ua.nure.calendar.persistent.user;

import ua.nure.calendar.persistent.SqlEntityConverter;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

class SqlUserConverter implements SqlEntityConverter<UserEntity> {
    private final String table;

    SqlUserConverter(String table) {
        this.table = checkNotNull(table);
    }

    @Override
    public UserEntity resultSetToEntity(@Nonnull ResultSet resultSet) {
        checkNotNull(resultSet);

        try {
            return new UserEntity(resultSet.getString("id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"));
        } catch (SQLException e) {
            throw new RuntimeException("Result set reading failed.", e);
        }
    }

    @Override
    public String entityInsertSql(@Nonnull UserEntity entity) {
        checkNotNull(entity);

        return String.format("INSERT INTO %s (id, login, password)" +
                        "VALUES('%s','%s','%s')",
                table,
                entity.id(),
                entity.login(),
                entity.password());
    }

    @Override
    public String entityUpdateSql(@Nonnull UserEntity record) {
        checkNotNull(record);

        return String.format("UPDATE %s " +
                        "SET " +
                        "login = '%s', " +
                        "password = '%s'" +
                        "WHERE id = '%s'",
                table,
                record.login(),
                record.password(),
                record.id());
    }
}

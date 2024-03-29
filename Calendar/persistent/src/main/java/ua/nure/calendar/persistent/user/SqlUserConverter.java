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
            return new UserEntity(
                    resultSet.getString("idUser"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getBoolean("isAdmin"),
                    resultSet.getBoolean("isTeacher"));
        } catch (SQLException e) {
            throw new RuntimeException("Result set reading failed.", e);
        }
    }

    @Override
    public String entityInsertSql(@Nonnull UserEntity entity) {
        checkNotNull(entity);

        return String.format("INSERT INTO %s (idUser, firstName, lastName, email, password, isAdmin, isTeacher)" +
                        "VALUES('%s','%s','%s','%s','%s','%b','%b')",
                table,
                entity.id(),
                entity.firstName(),
                entity.lastName(),
                entity.email(),
                entity.password(),
                entity.isAdmin(),
                entity.isTeacher());
    }

    @Override
    public String entityUpdateSql(@Nonnull UserEntity entity) {
        checkNotNull(entity);

        return String.format("UPDATE %s " +
                        "SET " +
                        "firstName = '%s', " +
                        "lastName = '%s', " +
                        "email = '%s', " +
                        "password = '%s'" +
                        "idUserRole = '%s'" +
                        "isAdmin = '%b', " +
                        "isTeacher = '%b', " +
                        "WHERE idUser = '%s'",
                table,
                entity.firstName(),
                entity.lastName(),
                entity.email(),
                entity.password(),
                entity.isAdmin(),
                entity.isTeacher(),
                entity.id());
    }
}

package ua.nure.calendar.persistent.authentication;

import ua.nure.calendar.persistent.SqlEntityConverter;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

public class SqlAuthenticationConverter implements SqlEntityConverter<AuthenticationEntity> {
    private final String table;

    SqlAuthenticationConverter(String table) {
        this.table = checkNotNull(table);
    }

    @Override
    public AuthenticationEntity resultSetToEntity(@Nonnull ResultSet resultSet) {
        checkNotNull(resultSet);
        try {
            return new AuthenticationEntity(
                    resultSet.getString("idAuthentication"),
                    resultSet.getString("idUser"),
                    resultSet.getString("token"),
                    resultSet.getDate("expirationDate"));
        } catch (SQLException e) {
            throw new RuntimeException("Result set reading failed.", e);
        }
    }

    @Override
    public String entityInsertSql(@Nonnull AuthenticationEntity entity) {
        checkNotNull(entity);

        return String.format("INSERT INTO %s (idAuthentication, idUser, token, expirationDate)" +
                        "VALUES('%s','%s','%s','%s')",
                table,
                entity.id(),
                entity.idUser(),
                entity.token(),
                entity.expirationDate());
    }

    @Override
    public String entityUpdateSql(@Nonnull AuthenticationEntity entity) {
        checkNotNull(entity);

        return String.format("UPDATE %s " +
                        "SET " +
                        "idUser = '%s', " +
                        "token = '%s', " +
                        "expirationDate = '%s', " +
                        "WHERE idAuthentication = '%s'",
                table,
                entity.idUser(),
                entity.token(),
                entity.expirationDate(),
                entity.id());
    }
}

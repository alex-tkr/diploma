package ua.nure.calendar.persistent.userRole;

import ua.nure.calendar.persistent.SqlEntityConverter;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

public class SqlUserRoleConverter implements SqlEntityConverter<UserRoleEntity> {
    private final String table;

    SqlUserRoleConverter(String table) {
        this.table = checkNotNull(table);
    }

    @Override
    public UserRoleEntity resultSetToEntity(@Nonnull ResultSet resultSet) {
        checkNotNull(resultSet);

        try {
            return new UserRoleEntity(
                    resultSet.getString("idUserRole"),
                    resultSet.getString("roleName"));
        } catch (SQLException e) {
            throw new RuntimeException("Result set reading failed.", e);
        }
    }

    @Override
    public String entityInsertSql(@Nonnull UserRoleEntity entity) {
        checkNotNull(entity);

        return String.format("INSERT INTO %s (idUserRole, roleName)" +
                        "VALUES('%s','%s')",
                table,
                entity.id(),
                entity.roleName());
    }

    @Override
    public String entityUpdateSql(@Nonnull UserRoleEntity entity) {
        checkNotNull(entity);

        return String.format("UPDATE %s " +
                        "SET " +
                        "roleName = '%s', " +
                        "WHERE idUserRole = '%s'",
                table,
                entity.id(),
                entity.roleName());
    }
}

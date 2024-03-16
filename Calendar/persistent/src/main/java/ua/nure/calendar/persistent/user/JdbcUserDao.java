package ua.nure.calendar.persistent.user;

import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.JdbcDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A {@link UserDao} implementation to work with authentication via JDBC as {@link JdbcDao}.
 */
public class JdbcUserDao extends JdbcDao<UserEntity> implements UserDao {

    public JdbcUserDao(DbConnection dbConnection,
                       String tableName) {

        super(checkNotNull(tableName),
                checkNotNull(dbConnection),
                new SqlUserConverter(tableName));
    }

    @Override
    public Optional<UserEntity> findByLogin(String login) {
        checkNotNull(login);

        String selectSqlQuery = String.format("SELECT * FROM %s WHERE login = '%s'", tableName(),
                login);

        try {
            ResultSet resultSet = dbConnection().executeQuery(selectSqlQuery);

            if (resultSet.next()) {
                return Optional.of(sqlEntityConverter().resultSetToEntity(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Database query failed.", e);
        }
    }
}

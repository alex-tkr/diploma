package ua.nure.calendar.persistent.authentication;

import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.JdbcDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class JdbcAuthenticationDao extends JdbcDao<AuthenticationEntity> implements AuthenticationDao {
    public JdbcAuthenticationDao(DbConnection dbConnection,
                                 String tableName) {

        super(checkNotNull(tableName),
                checkNotNull(dbConnection),
                new SqlAuthenticationConverter(tableName));
    }

    @Override
    public Optional<AuthenticationEntity> findByToken(String email) {
        checkNotNull(email);

        String selectSqlQuery = String.format("SELECT * FROM %s WHERE token = '%s'", tableName(),
                email);

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

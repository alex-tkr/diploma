package ua.nure.calendar.persistent.authentication;

import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.JdbcDao;

import static com.google.common.base.Preconditions.checkNotNull;

public class JdbcAuthenticationDao extends JdbcDao<AuthenticationEntity> implements AuthenticationDao {
    public JdbcAuthenticationDao(DbConnection dbConnection,
                        String tableName) {

        super(checkNotNull(tableName),
                checkNotNull(dbConnection),
                new SqlAuthenticationConverter(tableName));
    }
}

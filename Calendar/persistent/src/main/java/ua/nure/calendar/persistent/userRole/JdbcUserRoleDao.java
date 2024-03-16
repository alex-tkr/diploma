package ua.nure.calendar.persistent.userRole;

import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.JdbcDao;

import static com.google.common.base.Preconditions.checkNotNull;

public class JdbcUserRoleDao extends JdbcDao<UserRoleEntity> implements UserRoleDao {
    public JdbcUserRoleDao(DbConnection dbConnection,
                          String tableName) {

        super(checkNotNull(tableName),
                checkNotNull(dbConnection),
                new SqlUserRoleConverter(tableName));
    }
}

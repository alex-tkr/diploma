package ua.nure.calendar.persistent.group_user;

import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.JdbcDao;
import ua.nure.calendar.persistent.homework.SqlHomeworkConverter;

import static com.google.common.base.Preconditions.checkNotNull;

public class JdbcGroupUserDao extends JdbcDao<GroupUserEntity> implements GroupUserDao {
    public JdbcGroupUserDao(DbConnection dbConnection,
                           String tableName) {

        super(checkNotNull(tableName),
                checkNotNull(dbConnection),
                new SqlGroupUserConverter(tableName));
    }
}

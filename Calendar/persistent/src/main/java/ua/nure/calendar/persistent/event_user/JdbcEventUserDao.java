package ua.nure.calendar.persistent.event_user;

import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.JdbcDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class JdbcEventUserDao extends JdbcDao<EventUserEntity> implements EventUserDao {
    public JdbcEventUserDao(DbConnection dbConnection,
                       String tableName) {

        super(checkNotNull(tableName),
                checkNotNull(dbConnection),
                new SqlEventUserConverter(tableName));
    }
}

package ua.nure.calendar.persistent.event;

import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.JdbcDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class JdbcEventDao extends JdbcDao<EventEntity> implements EventDao {
    public JdbcEventDao(DbConnection dbConnection,
                        String tableName) {

        super(checkNotNull(tableName),
                checkNotNull(dbConnection),
                new SqlEventConverter(tableName));
    }
}

package ua.nure.calendar.persistent.group;

import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.JdbcDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class JdbcGroupDao extends JdbcDao<GroupEntity> implements GroupDao {
    public JdbcGroupDao(DbConnection dbConnection,
                        String tableName) {

        super(checkNotNull(tableName),
                checkNotNull(dbConnection),
                new SqlGroupConverter(tableName));
    }
}

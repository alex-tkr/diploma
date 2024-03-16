package ua.nure.calendar.persistent.homework;

import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.JdbcDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class JdbcHomeworkDao extends JdbcDao<HomeworkEntity> implements HomeworkDao {
    public JdbcHomeworkDao(DbConnection dbConnection,
                            String tableName) {

        super(checkNotNull(tableName),
                checkNotNull(dbConnection),
                new SqlHomeworkConverter(tableName));
    }
}

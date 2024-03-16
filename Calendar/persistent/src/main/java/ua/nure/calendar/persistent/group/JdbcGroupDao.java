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

    @Override
    public Optional<GroupEntity> findByGrade(int grade) {
        checkNotNull(grade);

        String selectSqlQuery = String.format("SELECT * FROM %s WHERE grade = '%s'", tableName(),
                grade);

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

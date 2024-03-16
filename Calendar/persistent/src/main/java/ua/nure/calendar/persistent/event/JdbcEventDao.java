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

    @Override
    public Optional<EventEntity> findByName(String name) {
        checkNotNull(name);

        String selectSqlQuery = String.format("SELECT * FROM %s WHERE name = '%s'", tableName(),
                name);

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

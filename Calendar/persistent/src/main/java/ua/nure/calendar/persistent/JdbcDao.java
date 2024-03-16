package ua.nure.calendar.persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A {@link DataAccessObject} implementation to work with databases via JDBC.
 * Provides CRUD operations.
 */
public class JdbcDao<E extends Entity> implements DataAccessObject<E> {

    private final String tableName;
    private final SqlEntityConverter<E> sqlEntityConverter;

    private final DbConnection dbConnection;

    protected JdbcDao(String tableName,
                      DbConnection dbConnection,
                      SqlEntityConverter<E> sqlEntityConverter) {

        this.tableName = checkNotNull(tableName);
        this.sqlEntityConverter = checkNotNull(sqlEntityConverter);
        this.dbConnection = checkNotNull(dbConnection);

    }

    @Override
    public Optional<E> findById(String id) {
        checkNotNull(id);

        String selectSqlQuery = String.format("SELECT * FROM %s WHERE id = '%s'", tableName, id);

        try {
            ResultSet resultSet = dbConnection.executeQuery(selectSqlQuery);

            if (resultSet.next()) {
                return Optional.of(sqlEntityConverter.resultSetToEntity(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database query failed.", e);
        }

        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        checkNotNull(id);

        String deleteSqlQuery = String.format("DELETE FROM %s WHERE id = '%s'", tableName, id);

        dbConnection.execute(deleteSqlQuery);

    }

    @Override
    public void create(E entity) {
        checkNotNull(entity);

        String insertSqlQuery = sqlEntityConverter.entityInsertSql(entity);

        dbConnection.execute((insertSqlQuery));

    }

    @Override
    public void update(E entity) {
        checkNotNull(entity);

        String updateSqlQuery = sqlEntityConverter.entityUpdateSql(entity);

        dbConnection.execute(updateSqlQuery);

    }

    protected DbConnection dbConnection() {
        return dbConnection;
    }

    protected String tableName() {
        return tableName;
    }

    protected SqlEntityConverter<E> sqlEntityConverter() {
        return sqlEntityConverter;
    }
}

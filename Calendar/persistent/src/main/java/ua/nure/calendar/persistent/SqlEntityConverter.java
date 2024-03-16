package ua.nure.calendar.persistent;

import javax.annotation.Nonnull;
import java.sql.ResultSet;

/**
 * Converter to provide work with {@link Entity} in SQL.
 *
 * @param <E> {@link Entity} type.
 */
public interface SqlEntityConverter<E extends Entity> {

    /**
     * Converts {@link ResultSet} into {@link E}.
     *
     * @param resultSet The query result set.
     * @return {@link E}
     */
    E resultSetToEntity(@Nonnull ResultSet resultSet);

    /**
     * Converts {@link E} into insert query on SQL.
     *
     * @param entity {@link E} to insert.
     * @return insert query on SQL.
     */
    String entityInsertSql(@Nonnull E entity);

    /**
     * Converts {@link E} into update query on SQL.
     *
     * @param entity {@link E} to update.
     * @return update query on SQL.
     */
    String entityUpdateSql(@Nonnull E entity);

}

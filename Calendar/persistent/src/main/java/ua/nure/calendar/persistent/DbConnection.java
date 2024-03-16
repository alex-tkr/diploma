package ua.nure.calendar.persistent;

import java.sql.*;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Database connection.
 * Provides an API to execute queries in Database.
 */
public class DbConnection {

    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;

    public DbConnection(String dbUrl,
                        String dbUser,
                        String dbPassword) {
        this.dbUrl = checkNotNull(dbUrl);
        this.dbUser = checkNotNull(dbUser);
        this.dbPassword = checkNotNull(dbPassword);
    }

    /**
     * Executes an SQL statement on a database without returning results.
     *
     * @param sql The SQL statement to execute.
     */
    public void execute(String sql) {
        checkNotNull(sql);

        try (Connection dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {

            Statement dbStatement = dbConnection.createStatement();
            dbStatement.execute(sql);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

    /**
     * Executes an SQL statement on a database with returning results.
     *
     * @param sql The SQL statement to execute.
     * @return Queried {@link ResultSet}.
     */
    public ResultSet executeQuery(String sql) {
        checkNotNull(sql);

        try (Connection dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {

            Statement dbStatement = dbConnection.createStatement();
            return dbStatement.executeQuery(sql);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }
}

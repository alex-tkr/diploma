import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.user.JdbcUserDao;
import ua.nure.calendar.persistent.user.UserDao;

import java.io.IOException;
import java.util.Properties;

public class ServicesConfiguration {

    private final UserDao userDao;

    public ServicesConfiguration() {
        var properties = new Properties();

        try (var resources = getClass().getClassLoader()
                .getResourceAsStream("database.properties")
        ) {
            properties.load(resources);
        } catch (IOException e) {
            throw new RuntimeException("Properties file reading failed.", e);
        }

        var dbConnection = new DbConnection(properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password"));

        userDao = new JdbcUserDao(dbConnection, "user");
    }

    public UserDao userDao() {
        return userDao;
    }
}

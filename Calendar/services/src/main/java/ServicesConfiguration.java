import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.authentication.AuthenticationDao;
import ua.nure.calendar.persistent.authentication.JdbcAuthenticationDao;
import ua.nure.calendar.persistent.event.EventDao;
import ua.nure.calendar.persistent.event.JdbcEventDao;
import ua.nure.calendar.persistent.event_user.EventUserDao;
import ua.nure.calendar.persistent.event_user.JdbcEventUserDao;
import ua.nure.calendar.persistent.group.GroupDao;
import ua.nure.calendar.persistent.group.JdbcGroupDao;
import ua.nure.calendar.persistent.group_user.GroupUserDao;
import ua.nure.calendar.persistent.group_user.JdbcGroupUserDao;
import ua.nure.calendar.persistent.homework.HomeworkDao;
import ua.nure.calendar.persistent.homework.JdbcHomeworkDao;
import ua.nure.calendar.persistent.user.JdbcUserDao;
import ua.nure.calendar.persistent.user.UserDao;

import java.io.IOException;
import java.util.Properties;

public class ServicesConfiguration {

    private final UserDao userDao;
    private final EventDao eventDao;
    private final EventUserDao eventUserDao;
    private final GroupDao groupDao;
    private final GroupUserDao groupUserDao;
    private final HomeworkDao homeworkDao;
    private final AuthenticationDao authenticationDao;


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
        eventDao = new JdbcEventDao(dbConnection, "event");
        eventUserDao = new JdbcEventUserDao(dbConnection, "event_user");
        groupDao = new JdbcGroupDao(dbConnection, "group");
        groupUserDao = new JdbcGroupUserDao(dbConnection, "group_user");
        homeworkDao = new JdbcHomeworkDao(dbConnection, "homework");
        authenticationDao = new JdbcAuthenticationDao(dbConnection, "authentication");

    }

    public UserDao userDao() {
        return userDao;
    }
    public EventDao eventDao() {
        return eventDao;
    }
    public EventUserDao eventUserDao() {
        return eventUserDao;
    }
    public GroupDao groupDao() {
        return groupDao;
    }
    public GroupUserDao groupUserDao() {
        return groupUserDao;
    }
    public HomeworkDao homeworkDao() {
        return homeworkDao;
    }
    public AuthenticationDao authenticationDao() {
        return authenticationDao;
    }
}

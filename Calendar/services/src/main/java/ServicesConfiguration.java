import ua.nure.calendar.persistent.DbConnection;
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
import ua.nure.calendar.persistent.payment.JdbcPaymentDao;
import ua.nure.calendar.persistent.payment.PaymentDao;
import ua.nure.calendar.persistent.user.JdbcUserDao;
import ua.nure.calendar.persistent.user.UserDao;
import ua.nure.calendar.persistent.userRole.JdbcUserRoleDao;
import ua.nure.calendar.persistent.userRole.UserRoleDao;
import ua.nure.calendar.persistent.user_payment.JdbcUserPaymentDao;
import ua.nure.calendar.persistent.user_payment.UserPaymentDao;

import java.io.IOException;
import java.util.Properties;

public class ServicesConfiguration {

    private final UserDao userDao;
    private final EventDao eventDao;
    private final EventUserDao eventUserDao;
    private final GroupDao groupDao;
    private final GroupUserDao groupUserDao;
    private final HomeworkDao homeworkDao;
    private final PaymentDao paymentDao;
    private final UserPaymentDao userPaymentDao;
    private final UserRoleDao userRoleDao;


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
        paymentDao = new JdbcPaymentDao(dbConnection, "payment");
        userPaymentDao = new JdbcUserPaymentDao(dbConnection, "user_payment");
        userRoleDao = new JdbcUserRoleDao(dbConnection, "userrole");

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
    public PaymentDao paymentDao() {
        return paymentDao;
    }
    public UserPaymentDao userPaymentDao() {
        return userPaymentDao;
    }
    public UserRoleDao userRoleDao() {
        return userRoleDao;
    }
}

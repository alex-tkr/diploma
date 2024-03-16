package ua.nure.calendar.persistent.user_payment;

import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.JdbcDao;

import static com.google.common.base.Preconditions.checkNotNull;

public class JdbcUserPaymentDao extends JdbcDao<UserPaymentEntity> implements UserPaymentDao {
    public JdbcUserPaymentDao(DbConnection dbConnection,
                          String tableName) {

        super(checkNotNull(tableName),
                checkNotNull(dbConnection),
                new SqlUserPaymentConverter(tableName));
    }
}

package ua.nure.calendar.persistent.payment;

import ua.nure.calendar.persistent.DbConnection;
import ua.nure.calendar.persistent.JdbcDao;
import ua.nure.calendar.persistent.homework.SqlHomeworkConverter;

import java.sql.Date;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;


public class JdbcPaymentDao extends JdbcDao<PaymentEntity> implements PaymentDao {
    public JdbcPaymentDao(DbConnection dbConnection,
                           String tableName) {

        super(checkNotNull(tableName),
                checkNotNull(dbConnection),
                new SqlPaymentConverter(tableName));
    }
}

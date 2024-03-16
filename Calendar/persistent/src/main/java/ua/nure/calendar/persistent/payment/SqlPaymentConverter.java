package ua.nure.calendar.persistent.payment;

import ua.nure.calendar.persistent.SqlEntityConverter;
import ua.nure.calendar.persistent.user.UserEntity;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

public class SqlPaymentConverter implements SqlEntityConverter<PaymentEntity> {
    private final String table;

    SqlPaymentConverter(String table) {
        this.table = checkNotNull(table);
    }

    @Override
    public PaymentEntity resultSetToEntity(@Nonnull ResultSet resultSet) {
        checkNotNull(resultSet);

        try {
            return new PaymentEntity(
                    resultSet.getString("idPayment"),
                    resultSet.getString("paymentDate"),
                    resultSet.getFloat("amount"),
                    resultSet.getString("note"));
        } catch (SQLException e) {
            throw new RuntimeException("Result set reading failed.", e);
        }
    }

    @Override
    public String entityInsertSql(@Nonnull PaymentEntity entity) {
        checkNotNull(entity);

        return String.format("INSERT INTO %s (idPayment, paymentDate, amount, note)" +
                        "VALUES('%s','%s','%s','%s')",
                table,
                entity.id(),
                entity.paymentDate(),
                entity.amount(),
                entity.note());
    }

    @Override
    public String entityUpdateSql(@Nonnull PaymentEntity entity) {
        checkNotNull(entity);

        return String.format("UPDATE %s " +
                        "SET " +
                        "paymentDate = '%s', " +
                        "amount = '%s', " +
                        "note = '%s', " +
                        "WHERE idPayment = '%s'",
                table,
                entity.id(),
                entity.paymentDate(),
                entity.amount(),
                entity.note());
    }
}

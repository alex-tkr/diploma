package ua.nure.calendar.persistent.user_payment;

import ua.nure.calendar.persistent.SqlEntityConverter;
import ua.nure.calendar.persistent.user.UserEntity;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

public class SqlUserPaymentConverter implements SqlEntityConverter<UserPaymentEntity> {
    private final String table;

    SqlUserPaymentConverter(String table) {
        this.table = checkNotNull(table);
    }

    @Override
    public UserPaymentEntity resultSetToEntity(@Nonnull ResultSet resultSet) {
        checkNotNull(resultSet);

        try {
            return new UserPaymentEntity(
                    resultSet.getString("idUserPayment"),
                    resultSet.getString("idUser"),
                    resultSet.getString("idPayment"));
        } catch (SQLException e) {
            throw new RuntimeException("Result set reading failed.", e);
        }
    }

    @Override
    public String entityInsertSql(@Nonnull UserPaymentEntity entity) {
        checkNotNull(entity);

        return String.format("INSERT INTO %s (idUserPayment, idUser, idPayment)" +
                        "VALUES('%s','%s','%s')",
                table,
                entity.id(),
                entity.idUser(),
                entity.idPayment());
    }

    @Override
    public String entityUpdateSql(@Nonnull UserPaymentEntity entity) {
        checkNotNull(entity);

        return String.format("UPDATE %s " +
                        "SET " +
                        "idUser = '%s', " +
                        "idPayment = '%s', " +
                        "WHERE idUserPayment = '%s'",
                table,
                entity.id(),
                entity.idUser(),
                entity.idPayment());
    }
}

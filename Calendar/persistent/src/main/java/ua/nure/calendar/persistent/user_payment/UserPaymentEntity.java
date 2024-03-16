package ua.nure.calendar.persistent.user_payment;

import ua.nure.calendar.persistent.Entity;

public class UserPaymentEntity extends Entity {

    private final int idUser;
    private final int idPayment;


    public UserPaymentEntity(int idUserPayment, int idUser, int idPayment) {
        super(idUserPayment);
        this.idUser = idUser;
        this.idPayment = idPayment;
    }

    public int idUser(){
        return idUser;
    }
    public int idPayment(){
        return idPayment;
    }
}

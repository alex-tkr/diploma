package ua.nure.calendar.persistent.user_payment;

import ua.nure.calendar.persistent.Entity;

public class UserPaymentEntity extends Entity {

    private final String idUser;
    private final String idPayment;


    public UserPaymentEntity(String idUserPayment, String idUser, String idPayment) {
        super(idUserPayment);
        this.idUser = idUser;
        this.idPayment = idPayment;
    }

    public String idUser(){
        return idUser;
    }
    public String idPayment(){
        return idPayment;
    }
}

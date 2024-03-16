package ua.nure.calendar.persistent.payment;

import ua.nure.calendar.persistent.Entity;

public class PaymentEntity extends Entity {
    private final String paymentDate;
    private final float amount;
    private final String note;

    public PaymentEntity(String idPayment, String paymentDate, float amount, String note) {
        super(idPayment);
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.note = note;
    }

    public String paymentDate(){
        return paymentDate;
    }
    public float amount(){
        return amount;
    }
    public String note(){
        return note;
    }
}

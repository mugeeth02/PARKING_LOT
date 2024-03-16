package models;

import java.util.Date;

public class Payment {
    private PaymentMode paymentMode;
    private String refNumber;
    private int amount;
    private Date time;
    private PaymentStatus paymentStatus;
}

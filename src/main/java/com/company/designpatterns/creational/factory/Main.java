package com.company.designpatterns.creational.factory;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        try {
            Payment payment = PaymentFactory.createPayment(PaymentMethod.APPLE_PAY);
            payment.pay(BigDecimal.valueOf(10000));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

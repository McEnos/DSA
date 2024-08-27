package com.company.designpatterns.creational.factory;

import java.text.MessageFormat;

public class PaymentFactory {
    public static Payment createPayment(PaymentMethod paymentMethod) throws ClassNotFoundException {
        switch (paymentMethod) {
            case GOOGLE_PAY -> {
                return new GooglePayPayment();
            }
            case CREDIT_CARD -> {
                return new CreditCardPayment();
            }
            case PAYPAL -> {
                return new PaypalPayment();
            }
            default ->
                    throw new ClassNotFoundException(MessageFormat.format("Payment {0} method not supported", paymentMethod));
        }
    }
}

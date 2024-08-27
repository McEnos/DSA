package com.company.designpatterns.creational.factory;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class GooglePayPayment implements Payment{
    @Override
    public void pay(BigDecimal amount) {
        System.out.println(MessageFormat.format("Successfully paid ${0} to a merchant using Google pay payment.", amount));
    }
}

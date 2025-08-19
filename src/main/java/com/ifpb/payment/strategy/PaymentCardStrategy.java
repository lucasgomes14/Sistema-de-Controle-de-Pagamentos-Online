package com.ifpb.payment.strategy;

public class PaymentCardStrategy implements PaymentStrategy {
    @Override
    public double calculateFinalAmount(double amount) {
        return amount +(amount * 0.05); //5% de taxa
    }
}

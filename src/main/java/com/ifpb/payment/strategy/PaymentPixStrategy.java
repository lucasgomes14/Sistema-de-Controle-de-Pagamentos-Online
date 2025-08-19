package com.ifpb.payment.strategy;

public class PaymentPixStrategy implements PaymentStrategy {
    @Override
    public double calculateFinalAmount(double amount) {
        return amount; // não contem taxa
    }
}

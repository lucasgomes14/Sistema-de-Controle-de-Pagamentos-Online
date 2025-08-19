package com.ifpb.payment.strategy;

public class PaymentTicketStrategy implements PaymentStrategy {
    @Override
    public double calculateFinalAmount(double amount) {
        return amount - (amount * 0.05); // desconto de 5%
    }
}

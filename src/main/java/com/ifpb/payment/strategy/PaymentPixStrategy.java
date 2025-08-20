package com.ifpb.payment.strategy;

import java.math.BigDecimal;

public class PaymentPixStrategy implements PaymentStrategy {
    @Override
    public BigDecimal calculateFinalAmount(BigDecimal amount) {
        return amount; // não contem taxa
    }
}

package com.ifpb.payment.strategy;

import java.math.BigDecimal;

public class PaymentCardStrategy implements PaymentStrategy {
    @Override
    public BigDecimal calculateFinalAmount(BigDecimal amount) {
        return amount.add(amount.multiply(new BigDecimal("0.05"))); //5% de taxa
    }
}

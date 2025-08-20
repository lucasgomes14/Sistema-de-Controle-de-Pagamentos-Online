package com.ifpb.payment.strategy;

import java.math.BigDecimal;

public class PaymentTicketStrategy implements PaymentStrategy {
    @Override
    public BigDecimal calculateFinalAmount(BigDecimal amount) {
        return amount.subtract(amount.multiply(new BigDecimal("0.05"))); // desconto de 5%
    }
}

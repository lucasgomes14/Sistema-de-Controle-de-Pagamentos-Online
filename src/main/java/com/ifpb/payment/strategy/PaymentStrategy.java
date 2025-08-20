package com.ifpb.payment.strategy;

import java.math.BigDecimal;

public interface PaymentStrategy {
    BigDecimal calculateFinalAmount(BigDecimal amount);
}

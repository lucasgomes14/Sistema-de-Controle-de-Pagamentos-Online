package com.ifpb.payment.decorator;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class PaymentBasic implements Payment {
    private final BigDecimal amount;

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String getDescription() {
        return "Pagamento básico";
    }
}

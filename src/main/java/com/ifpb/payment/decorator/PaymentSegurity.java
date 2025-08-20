package com.ifpb.payment.decorator;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class PaymentSegurity implements Payment {

    private final Payment payment;

    @Override
    public BigDecimal getAmount() {
        return payment.getAmount().add(new BigDecimal("5.0"));
    }

    @Override
    public String getDescription() {
        return payment.getDescription() + " com seguro";
    }
}

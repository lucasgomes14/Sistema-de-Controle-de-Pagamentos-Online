package com.ifpb.payment.decorator;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class PaymentCashback implements Payment {

    private final Payment payment;

    @Override
    public BigDecimal getAmount() {
        return payment.getAmount().multiply(new BigDecimal("0.01"));
    }

    @Override
    public String getDescription() {
        return payment.getDescription() + " com cashback";
    }
}

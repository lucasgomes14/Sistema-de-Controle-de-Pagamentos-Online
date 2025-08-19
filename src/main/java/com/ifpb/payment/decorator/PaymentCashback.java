package com.ifpb.payment.decorator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentCashback implements Payment {

    private final Payment payment;

    @Override
    public double getAmount() {
        return payment.getAmount() * 0.01;
    }

    @Override
    public String getDescription() {
        return payment.getDescription() + " com cashback";
    }
}

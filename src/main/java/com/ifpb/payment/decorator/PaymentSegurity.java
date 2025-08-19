package com.ifpb.payment.decorator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentSegurity implements Payment {

    private final Payment payment;

    @Override
    public double getAmount() {
        return payment.getAmount() + 5.0;
    }

    @Override
    public String getDescription() {
        return payment.getDescription() + " com seguro";
    }
}

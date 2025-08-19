package com.ifpb.payment.decorator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentBasic implements Payment {
    private final double amount;

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getDescription() {
        return "Pagamento básico";
    }
}

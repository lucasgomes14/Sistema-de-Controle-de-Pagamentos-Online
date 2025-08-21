package com.ifpb.payment.decorator;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

// ================== DECORATOR ==================
// O padrão Decorator foi usado para adicionar dinamicamente funcionalidades
// extras a um pagamento, como cashback e seguro.
// Isso evita a criação de múltiplas subclasses para cada combinação de opções.
// Exemplo: um pagamento com cashback e seguro é apenas uma composição de decoradores.

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

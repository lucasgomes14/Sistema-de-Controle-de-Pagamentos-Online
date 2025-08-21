package com.ifpb.payment.decorator;

import java.math.BigDecimal;

// ================== DECORATOR ==================
// O padrão Decorator foi usado para adicionar dinamicamente funcionalidades
// extras a um pagamento, como cashback e seguro.
// Isso evita a criação de múltiplas subclasses para cada combinação de opções.
// Exemplo: um pagamento com cashback e seguro é apenas uma composição de decoradores.

public interface Payment {
    BigDecimal getAmount();
    String getDescription();
}

package com.ifpb.payment.strategy;

import java.math.BigDecimal;

// ================== STRATEGY ==================
// O padrão Strategy foi aplicado para tratar a lógica de cálculo
// do valor final de um pagamento, que pode variar de acordo com o método.
// Isso permite adicionar novos métodos sem alterar o código existente,
// apenas criando novas implementações de PaymentStrategy.


public class PaymentTicketStrategy implements PaymentStrategy {
    @Override
    public BigDecimal calculateFinalAmount(BigDecimal amount) {
        return amount.subtract(amount.multiply(new BigDecimal("0.05"))); // desconto de 5%
    }
}

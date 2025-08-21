package com.ifpb.payment.observer;

import com.ifpb.payment.model.PaymentEntity;

// ================== OBSERVER ==================
// O padrão Observer foi usado para notificar automaticamente os clientes
// após a realização de um pagamento. Cada observador (ex: EmailObserver)
// é inscrito na lista da Facade e recebe o evento de pagamento concluído.
// Isso facilita adicionar/remover notificações sem alterar a lógica central.

public interface PaymentObserver {
    void notify(PaymentEntity payment);
}

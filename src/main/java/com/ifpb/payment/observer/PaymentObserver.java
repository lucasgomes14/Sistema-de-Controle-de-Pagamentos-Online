package com.ifpb.payment.observer;

import com.ifpb.payment.model.PaymentEntity;

public interface PaymentObserver {
    void notify(PaymentEntity payment);
}

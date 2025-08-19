package com.ifpb.payment.observer;

import com.ifpb.payment.model.PaymentEntity;
import org.springframework.stereotype.Component;

@Component
public class EmailObserver implements PaymentObserver {

    @Override
    public void notify(PaymentEntity payment) {
        System.out.println("Email notification: " + payment.getClient().getEmail());
    }
}

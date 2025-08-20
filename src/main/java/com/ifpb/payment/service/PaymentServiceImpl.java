package com.ifpb.payment.service;

import com.ifpb.payment.facade.PaymentFacade;
import com.ifpb.payment.model.PaymentEntity;
import com.ifpb.payment.strategy.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentFacade facade;

    @Override
    public PaymentEntity makePayment(PaymentEntity payment, PaymentStrategy strategy) {
        return facade.processPayment(payment, strategy);
    }
}

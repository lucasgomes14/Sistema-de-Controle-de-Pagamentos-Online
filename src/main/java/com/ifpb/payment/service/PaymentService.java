package com.ifpb.payment.service;

import com.ifpb.payment.dto.request.PaymentRequestDTO;
import com.ifpb.payment.model.PaymentEntity;
import com.ifpb.payment.strategy.PaymentStrategy;

public interface PaymentService {
    PaymentEntity makePayment(PaymentEntity payment, PaymentStrategy strategy);
    void validateMethodPayment(PaymentRequestDTO dto);
}

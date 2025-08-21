package com.ifpb.payment.service;

import com.ifpb.payment.dto.request.PaymentRequestDTO;
import com.ifpb.payment.dto.response.PaymentResponseDTO;
import com.ifpb.payment.exception.InvalidMethodException;
import com.ifpb.payment.facade.PaymentFacade;
import com.ifpb.payment.model.PaymentEntity;
import com.ifpb.payment.strategy.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentFacade facade;

    @Override
    public PaymentEntity makePayment(PaymentEntity payment, PaymentStrategy strategy) {
        return facade.processPayment(payment, strategy);
    }

    @Override
    public void validateMethodPayment(PaymentRequestDTO dto) {
        if (!(dto.method().equalsIgnoreCase("pix") || dto.method().equalsIgnoreCase("boleto") || dto.method().equalsIgnoreCase("cartao"))) {
            throw new InvalidMethodException("Método '" + dto.method() + "' inválido");
        }
    }

    @Override
    public List<PaymentResponseDTO> getAllPayments() {
        return List.of();
    }

    @Override
    public PaymentResponseDTO getPayment() {
        return null;
    }
}

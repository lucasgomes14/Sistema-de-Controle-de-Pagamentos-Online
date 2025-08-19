package com.ifpb.payment.controller;

import com.ifpb.payment.dto.request.PaymentRequestDTO;
import com.ifpb.payment.mapper.PaymentMapper;
import com.ifpb.payment.model.Client;
import com.ifpb.payment.model.PaymentEntity;
import com.ifpb.payment.service.PaymentService;
import com.ifpb.payment.strategy.PaymentCardStrategy;
import com.ifpb.payment.strategy.PaymentPixStrategy;
import com.ifpb.payment.strategy.PaymentStrategy;
import com.ifpb.payment.strategy.PaymentTicketStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentControllerImpl implements PaymentController {

    private final PaymentService service;
    private final PaymentMapper mapper;

    @Override
    public ResponseEntity<Void> pay(PaymentRequestDTO dto) {
        PaymentStrategy strategy;

        Client client = service.saveClient(mapper.toClientEntity(dto));
        PaymentEntity payment = mapper.toPaymentEntity(dto, client);

        switch (payment.getMethod().toUpperCase()) {
            case "CARTAO" -> strategy = new PaymentCardStrategy();
            case "PIX" -> strategy = new PaymentPixStrategy();
            case "BOLETO" -> strategy = new PaymentTicketStrategy();
            default -> throw new IllegalArgumentException("Método de pagamento inválido");
        }

        service.makePayment(payment, strategy);

        return ResponseEntity.ok().build();
    }
}

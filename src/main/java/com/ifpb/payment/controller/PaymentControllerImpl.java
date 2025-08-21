package com.ifpb.payment.controller;

import com.ifpb.payment.dto.request.PaymentRequestDTO;
import com.ifpb.payment.dto.response.PaymentResponseDTO;
import com.ifpb.payment.exception.InvalidMethodException;
import com.ifpb.payment.model.Client;
import com.ifpb.payment.model.PaymentEntity;
import com.ifpb.payment.service.ClientService;
import com.ifpb.payment.service.PaymentService;
import com.ifpb.payment.strategy.PaymentCardStrategy;
import com.ifpb.payment.strategy.PaymentPixStrategy;
import com.ifpb.payment.strategy.PaymentStrategy;
import com.ifpb.payment.strategy.PaymentTicketStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentControllerImpl implements PaymentController {

    private final PaymentService paymentService;
    private final ClientService clientService;

    @Override
    public ResponseEntity<Void> pay(Long idClient, PaymentRequestDTO dto) {
        Client client = clientService.getClientEntity(idClient);
        paymentService.validateMethodPayment(dto);

        PaymentStrategy strategy;
        PaymentEntity payment = paymentService.paymentEntity(dto, client);

        switch (payment.getMethod().toUpperCase()) {
            case "CARTAO" -> strategy = new PaymentCardStrategy();
            case "PIX" -> strategy = new PaymentPixStrategy();
            case "BOLETO" -> strategy = new PaymentTicketStrategy();
            default -> throw new InvalidMethodException("Método de pagamento inválido");
        }

        paymentService.makePayment(payment, strategy);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<PaymentResponseDTO>> getAllPayments() {
        List<PaymentResponseDTO> response = paymentService.getAllPayments();

        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<PaymentResponseDTO> getPayment(Long id) {
        PaymentResponseDTO response = paymentService.getPayment(id);

        return ResponseEntity.ok().body(response);
    }
}

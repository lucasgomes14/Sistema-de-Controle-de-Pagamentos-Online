package com.ifpb.payment.service;

import com.ifpb.payment.dto.request.PaymentRequestDTO;
import com.ifpb.payment.dto.response.PaymentResponseDTO;
import com.ifpb.payment.exception.InvalidMethodException;
import com.ifpb.payment.exception.PaymentNotFoundException;
import com.ifpb.payment.facade.PaymentFacade;
import com.ifpb.payment.mapper.PaymentMapper;
import com.ifpb.payment.model.Client;
import com.ifpb.payment.model.PaymentEntity;
import com.ifpb.payment.repository.PaymentRepository;
import com.ifpb.payment.strategy.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentFacade facade;
    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    @Override
    public PaymentEntity paymentEntity(PaymentRequestDTO dto, Client client) {
        return mapper.toPaymentEntity(dto, client);
    }

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
        List<PaymentEntity> payments = repository.findAll();
        List<PaymentResponseDTO> response = new ArrayList<>();

        for (PaymentEntity payment : payments) {
            response.add(new PaymentResponseDTO(payment.getAmount(), payment.getMethod(), payment.getLocalDateTime(), payment.getClient().getName(), payment.getClient().getEmail()));
        }

        return response;
    }

    @Override
    public PaymentResponseDTO getPayment(Long id) {
        PaymentEntity payment = repository.findById(id).orElseThrow(() -> new PaymentNotFoundException("Pagamento não encontrado"));

        return new PaymentResponseDTO(payment.getAmount(), payment.getMethod(), payment.getLocalDateTime(), payment.getClient().getName(), payment.getClient().getEmail());
    }
}

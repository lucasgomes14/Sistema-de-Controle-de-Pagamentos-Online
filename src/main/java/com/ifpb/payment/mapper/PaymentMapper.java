package com.ifpb.payment.mapper;

import com.ifpb.payment.dto.request.PaymentRequestDTO;
import com.ifpb.payment.model.Client;
import com.ifpb.payment.model.PaymentEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentMapper {
    public PaymentEntity toPaymentEntity(PaymentRequestDTO dto, Client client) {
        PaymentEntity entity = new PaymentEntity();

        entity.setAmount(dto.amount());
        entity.setMethod(dto.method());
        entity.setLocalDateTime(LocalDateTime.now());
        entity.setClient(client);

        if (dto.method().equalsIgnoreCase("CARTAO")) {
            entity.setSecurity(dto.security());
            entity.setCashback(dto.cashback());
        }

        return entity;
    }
}

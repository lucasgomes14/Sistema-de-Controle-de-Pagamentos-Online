package com.ifpb.payment.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentClientResponseDTO(
        BigDecimal amount,
        String method,
        LocalDateTime dateTime) {
}

package com.ifpb.payment.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResponseDTO(
        BigDecimal amount,
        String method,
        LocalDateTime dateTime,
        String nameClient,
        String emailClient
) {
}

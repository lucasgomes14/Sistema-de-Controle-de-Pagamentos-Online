package com.ifpb.payment.dto.response;

import java.math.BigDecimal;

public record PaymentResponseDTO(
        BigDecimal amount,
        String method
) {
}

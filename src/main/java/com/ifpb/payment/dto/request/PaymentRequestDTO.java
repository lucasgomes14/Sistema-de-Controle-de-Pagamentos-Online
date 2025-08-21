package com.ifpb.payment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PaymentRequestDTO(
        @Positive(message = "Valor do pagamento tem que ser positivo!") BigDecimal amount,
        @NotBlank(message = "Método é obrigatório") String method,
        boolean security,
        boolean cashback
) {
}

package com.ifpb.payment.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;

public record PaymentRequestDTO(@Positive(message = "Valor do pagamento tem que ser positivo!") double amount,
                                @NotBlank(message = "Método é obrigatório") String method,
                                @NotBlank(message = "Nome é obrigatório") String name,
                                @Email(message = "Email é obrigatório") String email) {
}

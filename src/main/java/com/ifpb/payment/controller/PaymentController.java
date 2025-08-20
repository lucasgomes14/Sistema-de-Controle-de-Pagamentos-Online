package com.ifpb.payment.controller;

import com.ifpb.payment.dto.request.PaymentRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentController {
    @Operation(
            summary = "Fazer pagamento",
            description = "Recebe no corpo o valor, o método, nome do cliente e email"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento realizado"),
            @ApiResponse(responseCode = "500", description = "Erro inesperado")
    })
    @PostMapping("/pay")
    ResponseEntity<Void> pay(@Valid @RequestBody PaymentRequestDTO dto);
}

package com.ifpb.payment.controller;

import com.ifpb.payment.dto.request.PaymentRequestDTO;
import com.ifpb.payment.dto.response.PaymentResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PaymentController {
    @Operation(
            summary = "Fazer pagamento",
            description = "Recebe no corpo o valor, o método, nome do cliente e email"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pagamento realizado"),
            @ApiResponse(responseCode = "400", description = "Alguma entrada errada"),
            @ApiResponse(responseCode = "500", description = "Erro inesperado")
    })
    @PostMapping("/pay/{idClient}")
    ResponseEntity<Void> pay(@PathVariable Long idClient, @Valid @RequestBody PaymentRequestDTO dto);

    @Operation(
            summary = "Retorna todos pagamentos",
            description = "Retorna todos os pagamentos cadastrados no sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamentos retornados"),
            @ApiResponse(responseCode = "500", description = "Erro inesperado")
    })
    @GetMapping("/payments")
    ResponseEntity<List<PaymentResponseDTO>> getAllPayments();

    @Operation(
            summary = "Retorna o pagamento específico",
            description = "Retorna o pagamento específico do sistema caso exista"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamentos retornados"),
            @ApiResponse(responseCode = "404", description = "Pagamento não existe"),
            @ApiResponse(responseCode = "500", description = "Erro inesperado")
    })
    @GetMapping("/payment/{id}")
    ResponseEntity<PaymentResponseDTO> getPayment(@PathVariable Long id);
}

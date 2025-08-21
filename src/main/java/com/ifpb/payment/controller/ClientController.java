package com.ifpb.payment.controller;

import com.ifpb.payment.dto.request.ClientRequestDTO;
import com.ifpb.payment.dto.response.ClientResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientController {
    @Operation(
            summary = "Cadastrar cliente",
            description = "Recebe no corpo o nome do cliente e email"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente cadastrado"),
            @ApiResponse(responseCode = "400", description = "Alguma entrada errada"),
            @ApiResponse(responseCode = "500", description = "Erro inesperado")
    })
    @PostMapping("/client")
    ResponseEntity<Void> cadasterClient(@Valid @RequestBody ClientRequestDTO dto);

    @Operation(
            summary = "Retorna clientes",
            description = "Retorna lista de clientes cadastrados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientes retornados"),
            @ApiResponse(responseCode = "500", description = "Erro inesperado")
    })
    @GetMapping("/clients")
    ResponseEntity<List<ClientResponseDTO>> getAllClients();

    @Operation(
            summary = "Retorna cliente específico",
            description = "Retorna cliente cadastrados caso o id exista"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente retornado"),
            @ApiResponse(responseCode = "404", description = "Cliente não existe"),
            @ApiResponse(responseCode = "500", description = "Erro inesperado")
    })
    @GetMapping("/client/{id}")
    ResponseEntity<ClientResponseDTO> getClient(@PathVariable Long id);

    @Operation(
            summary = "Atualiza cliente específico",
            description = "Recebe no corpo o nome do cliente e email e o id como parâmetro"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado"),
            @ApiResponse(responseCode = "400", description = "Alguma entrada errada"),
            @ApiResponse(responseCode = "404", description = "Cliente não existe"),
            @ApiResponse(responseCode = "500", description = "Erro inesperado")
    })
    @PutMapping("/client/{id}")
    ResponseEntity<Void> updateClient(@PathVariable Long id, @Valid @RequestBody ClientRequestDTO dto);

    @Operation(
            summary = "Remove cliente específico",
            description = "Recebe id como parâmetro"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente removido"),
            @ApiResponse(responseCode = "404", description = "Cliente não existe"),
            @ApiResponse(responseCode = "500", description = "Erro inesperado")
    })
    @DeleteMapping("/client/{id}")
    ResponseEntity<Void> deleteClient(@PathVariable Long id);
}

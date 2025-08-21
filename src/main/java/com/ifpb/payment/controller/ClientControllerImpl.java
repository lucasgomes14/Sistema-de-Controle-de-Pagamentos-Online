package com.ifpb.payment.controller;

import com.ifpb.payment.dto.request.ClientRequestDTO;
import com.ifpb.payment.dto.response.ClientResponseDTO;
import com.ifpb.payment.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientControllerImpl implements ClientController {

    private final ClientService service;

    @Override
    public ResponseEntity<Void> cadasterClient(ClientRequestDTO dto) {
        service.saveClient(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
        List<ClientResponseDTO> response = service.getAllClients();

        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<ClientResponseDTO> getClient(Long id) {
        ClientResponseDTO response = service.getClient(id);

        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<Void> updateClient(Long id, ClientRequestDTO dto) {
        service.updateClient(id, dto);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteClient(Long id) {
        service.deleteClient(id);

        return ResponseEntity.ok().build();
    }
}

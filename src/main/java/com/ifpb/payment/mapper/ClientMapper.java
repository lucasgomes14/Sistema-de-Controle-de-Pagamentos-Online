package com.ifpb.payment.mapper;

import com.ifpb.payment.dto.request.ClientRequestDTO;
import com.ifpb.payment.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client toEntity(ClientRequestDTO dto) {
        Client client = new Client();

        client.setName(dto.name());
        client.setEmail(dto.email());

        return client;
    }
}

package com.ifpb.payment.service;

import com.ifpb.payment.dto.request.ClientRequestDTO;
import com.ifpb.payment.dto.response.ClientResponseDTO;
import com.ifpb.payment.exception.ClientNotFoundException;
import com.ifpb.payment.mapper.ClientMapper;
import com.ifpb.payment.model.Client;
import com.ifpb.payment.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    @Override
    public Client saveClient(ClientRequestDTO dto) {
        Client client = mapper.toEntity(dto);

        return clientRepository.save(client);
    }

    @Override
    public List<ClientResponseDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponseDTO> response = new ArrayList<>();

        for (Client client : clients) {
            ClientResponseDTO responseDTO = new ClientResponseDTO(client.getName(), client.getEmail());

            response.add(responseDTO);
        }

        return response;
    }

    @Override
    public ClientResponseDTO getClient(Long id) {
        Client client = getClientEntity(id);

        return new ClientResponseDTO(client.getName(), client.getEmail());
    }

    @Override
    public void updateClient(Long id, ClientRequestDTO dto) {
        Client client = getClientEntity(id);

        client.setName(dto.name());
        client.setEmail(dto.email());

        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = getClientEntity(id);

        clientRepository.delete(client);
    }

    public Client getClientEntity(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado"));
    }
}

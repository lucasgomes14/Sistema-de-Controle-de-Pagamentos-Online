package com.ifpb.payment.service;

import com.ifpb.payment.dto.request.ClientRequestDTO;
import com.ifpb.payment.dto.response.ClientResponseDTO;
import com.ifpb.payment.dto.response.PaymentClientResponseDTO;
import com.ifpb.payment.model.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(ClientRequestDTO dto);
    List<ClientResponseDTO> getAllClients();
    ClientResponseDTO getClient(Long id);
    void updateClient(Long id, ClientRequestDTO dto);
    void deleteClient(Long id);
    Client getClientEntity(Long id);
    List<PaymentClientResponseDTO> getAllPayments(Long id);
}

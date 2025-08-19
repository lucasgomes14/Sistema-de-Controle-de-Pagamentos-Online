package com.ifpb.payment.service;

import com.ifpb.payment.facade.PaymentFacade;
import com.ifpb.payment.model.Client;
import com.ifpb.payment.model.PaymentEntity;
import com.ifpb.payment.repository.ClientRepository;
import com.ifpb.payment.strategy.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentFacade facade;
    private final ClientRepository clientRepository;

    @Override
    public PaymentEntity makePayment(PaymentEntity payment, PaymentStrategy strategy) {
        return facade.processPayment(payment, strategy);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}

package com.ifpb.payment.facade;

import com.ifpb.payment.decorator.Payment;
import com.ifpb.payment.decorator.PaymentBasic;
import com.ifpb.payment.decorator.PaymentCashback;
import com.ifpb.payment.decorator.PaymentSegurity;
import com.ifpb.payment.model.PaymentEntity;
import com.ifpb.payment.observer.PaymentObserver;
import com.ifpb.payment.repository.PaymentRepository;
import com.ifpb.payment.strategy.PaymentStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PaymentFacade {
    private final PaymentRepository paymentRepository;
    private final List<PaymentObserver> observers;

    public PaymentFacade(PaymentRepository paymentRepository, List<PaymentObserver> observers) {
        this.paymentRepository = paymentRepository;

        this.observers = observers;
    }

    public PaymentEntity processPayment(PaymentEntity payment, PaymentStrategy strategy) {
        BigDecimal finalAmount = strategy.calculateFinalAmount(payment.getAmount());
        Payment decorator = new PaymentBasic(finalAmount);

        if (payment.getMethod().equalsIgnoreCase("CARTAO")) {

            if (payment.isCashback()) {
                decorator = new PaymentCashback(decorator);
            }

            if (payment.isSecurity()) {
                decorator = new PaymentSegurity(decorator);
            }
        }


        payment.setAmount(decorator.getAmount());

        PaymentEntity save = paymentRepository.save(payment);

        observers.forEach(o -> o.notify(save));

        return save;
    }
}

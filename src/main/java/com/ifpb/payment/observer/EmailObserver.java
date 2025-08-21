package com.ifpb.payment.observer;

import com.ifpb.payment.model.PaymentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailObserver implements PaymentObserver {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Override
    public void notify(PaymentEntity payment) {
        try {
            var message = new SimpleMailMessage();
            message.setTo(payment.getClient().getEmail());
            message.setFrom(emailFrom);
            message.setSubject("Pagamento efetuado");
            message.setText("Obrigado " + payment.getClient().getName() + " por efetuar o pagamento de " + payment.getAmount() + "R$.");

            mailSender.send(message);
        } catch (MailException e) {
            throw new MailException("Erro ao enviar email") {
            };
        }
        System.out.println("Email notification: " + payment.getClient().getEmail());
    }
}

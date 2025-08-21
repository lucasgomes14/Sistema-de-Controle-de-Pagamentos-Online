package com.ifpb.payment.repository;

import com.ifpb.payment.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ================== REPOSITORY ==================
// O padrão Repository foi aplicado com Spring Data JPA para abstrair
// o acesso ao banco de dados. Assim, não precisamos escrever SQL manualmente.
// Ele também facilita a troca de implementação (ex: trocar de Postgres para MySQL)
// sem impactar a lógica de negócio.

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}

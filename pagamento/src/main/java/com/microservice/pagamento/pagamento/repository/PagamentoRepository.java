package com.microservice.pagamento.pagamento.repository;

import com.microservice.pagamento.pagamento.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
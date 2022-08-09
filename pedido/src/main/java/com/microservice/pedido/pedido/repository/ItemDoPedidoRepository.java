package com.microservice.pedido.pedido.repository;

import com.microservice.pedido.pedido.entity.ItemDoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido, Long> {
}

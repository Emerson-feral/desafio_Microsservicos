package com.microservice.pedido.pedido.dto;

import com.microservice.pedido.pedido.entity.ItemDoPedido;
import com.microservice.pedido.pedido.enums.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PedidoDTO {

    private Long id;
    private LocalDate dataHora;
    private Status status;
    private List<ItemDoPedido> itens;
}

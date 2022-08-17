package com.microservice.pedido.pedido.dto;

import com.microservice.pedido.pedido.entity.Pedido;
import lombok.Data;

@Data
public class ItemDoPedidoDTO {

    private Long id;
    private Integer quantidade;
    private String descricao;
    private Pedido pedido;
}

package com.microservice.pedido.pedido.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item_do_pedido")
@Getter
@Setter
public class ItemDoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer quantidade;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_id_pedido",nullable = false)
    @NonNull
    private Pedido pedido;

}

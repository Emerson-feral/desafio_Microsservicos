package com.microservice.pedido.pedido.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservice.pedido.pedido.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate dataHora;

    private Status status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ItemDoPedido> itens;

}

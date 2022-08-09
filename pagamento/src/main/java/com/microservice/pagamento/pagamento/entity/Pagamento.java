package com.microservice.pagamento.pagamento.entity;

import com.microservice.pagamento.pagamento.enums.FormaDePagamento;
import com.microservice.pagamento.pagamento.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotEmpty
    @Size(max = 100)
    private String nome;

    @NotEmpty
    @Size(max = 100)
    private String numero;

    private String expiracao;

    @NotEmpty
    @Size(min = 3,max = 3)
    private String codigo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    private Long pedidoId;

    private FormaDePagamento formaDePagamento;
}
package com.microservice.pedido.pedido.service;

import com.microservice.pedido.pedido.entity.Pedido;
import com.microservice.pedido.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;
    public List<Pedido> getPedidos() {
        return repository.findAll();
    }

    public Pedido getPedidoById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pedido savePedido(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido updatePedido(Pedido pedido) {
        return repository.save(pedido);

    }

    public void detelePedidoById(Long id) {
        repository.deleteById(id);
    }
}


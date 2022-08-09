package com.microservice.pedido.pedido.service;

import com.microservice.pedido.pedido.entity.ItemDoPedido;
import com.microservice.pedido.pedido.repository.ItemDoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDoPedidoService {

    @Autowired
    ItemDoPedidoRepository repository;

    public List<ItemDoPedido> getItemDoPedido() {
        return repository.findAll();
    }

    public ItemDoPedido getItemDoPedidoById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ItemDoPedido saveItemDoPedido(ItemDoPedido itemDoPedido) {
        return repository.save(itemDoPedido);
    }

    public ItemDoPedido updateItemDoPedido(ItemDoPedido itemDoPedido) {
        return repository.save(itemDoPedido);

    }

    public void deteleItemDoPedidoById(Long id) {
        repository.deleteById(id);
    }
}
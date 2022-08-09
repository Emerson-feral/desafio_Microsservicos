package com.microservice.pedido.pedido.controller;

import com.microservice.pedido.pedido.entity.ItemDoPedido;
import com.microservice.pedido.pedido.service.ItemDoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemdopedido")
public class ItemdoPedidoController {

    @Autowired
    ItemDoPedidoService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDoPedido> findAllItemDoPedido(){
        return service.getItemDoPedido();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDoPedido findItemDoPedidoById(@PathVariable Long id){
        return service.getItemDoPedidoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDoPedido addItemDoPedido(@RequestBody ItemDoPedido itemDoPedido){
        return service.saveItemDoPedido(itemDoPedido);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDoPedido updateItemDoPedido(@RequestBody ItemDoPedido itemDoPedido, @PathVariable Long id){
        itemDoPedido.setId(id);
        return service.updateItemDoPedido(itemDoPedido);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItemDoPedido(@PathVariable Long id){
        service.deteleItemDoPedidoById(id);
    }
}

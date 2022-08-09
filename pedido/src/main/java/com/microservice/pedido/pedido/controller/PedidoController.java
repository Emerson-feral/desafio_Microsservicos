package com.microservice.pedido.pedido.controller;

import com.microservice.pedido.pedido.entity.Pedido;
import com.microservice.pedido.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pedido> findAllPedidos(){
        return service.getPedidos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido findPedidoById(@PathVariable Long id){
        return service.getPedidoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido addPedido(@RequestBody Pedido pedido){
        return service.savePedido(pedido);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido updatePedido(@RequestBody Pedido pedido, @PathVariable Long id){
        pedido.setId(id);
        return service.updatePedido(pedido);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePedido(@PathVariable Long id){
        service.detelePedidoById(id);
    }
}

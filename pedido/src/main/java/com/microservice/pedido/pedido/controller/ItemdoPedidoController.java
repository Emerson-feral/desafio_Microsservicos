package com.microservice.pedido.pedido.controller;

import com.microservice.pedido.pedido.dto.ItemDoPedidoDTO;
import com.microservice.pedido.pedido.entity.ItemDoPedido;
import com.microservice.pedido.pedido.service.ItemDoPedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/itemdopedido")
public class ItemdoPedidoController {

    @Autowired
    ItemDoPedidoService service;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDoPedidoDTO> findAllItemDoPedido(){

        return service.getItemDoPedido()
                .stream()
                .map(itemDoPedido -> modelMapper.map(itemDoPedido,ItemDoPedidoDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDoPedidoDTO> findItemDoPedidoById(@PathVariable Long id){
        var itemDoPedido = service.getItemDoPedidoById(id);

        // convert DTO to entity
        var itemDoPedidoReponse = modelMapper.map(itemDoPedido,ItemDoPedidoDTO.class);

        return  ResponseEntity.ok().body(itemDoPedidoReponse);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ItemDoPedidoDTO> addItemDoPedido(@RequestBody ItemDoPedido itemDoPedidoDto){
        // convert DTO to entity
        var itemDoPedidoRequest = modelMapper.map(itemDoPedidoDto,ItemDoPedido.class);
        var itemDoPedido = service.saveItemDoPedido(itemDoPedidoRequest);

        // convert entity to DTO
        var itemDoPedidoReponse = modelMapper.map(itemDoPedido,ItemDoPedidoDTO.class);

        return new ResponseEntity<ItemDoPedidoDTO>(itemDoPedidoReponse,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ItemDoPedidoDTO> updateItemDoPedido(@RequestBody ItemDoPedidoDTO itemDoPedidoDto, @PathVariable Long id){
        // convert DTO to Entity
        var itemDoPedidoRequest = modelMapper.map(itemDoPedidoDto,ItemDoPedido.class);
        itemDoPedidoRequest.setId(id);

        var itemDoPedido = service.updateItemDoPedido(itemDoPedidoRequest);

        // entity to DTO
        var itemDoPedidoResponse = modelMapper.map(itemDoPedido,ItemDoPedidoDTO.class);
        return  ResponseEntity.ok().body(itemDoPedidoResponse);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItemDoPedido(@PathVariable Long id){
        service.deteleItemDoPedidoById(id);
    }
}

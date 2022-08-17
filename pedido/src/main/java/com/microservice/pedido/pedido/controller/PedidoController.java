package com.microservice.pedido.pedido.controller;

import com.microservice.pedido.pedido.dto.PedidoDTO;
import com.microservice.pedido.pedido.entity.Pedido;
import com.microservice.pedido.pedido.service.PedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDTO> findAllPedidos(){
        return service.getPedidos()
                .stream()
                .map(pedido -> modelMapper.map(pedido,PedidoDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findPedidoById(@PathVariable Long id) {
        var pedido = service.getPedidoById(id);

        //covert DTO to Entity
        var pedidoResponse = modelMapper.map(pedido,PedidoDTO.class);

        return ResponseEntity.ok().body(pedidoResponse);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> addPedido(@RequestBody PedidoDTO pedidoDto){

        //convert DTO to Entity
        var pedidoRequest = modelMapper.map(pedidoDto,Pedido.class);
        var pedido = service.savePedido(pedidoRequest);

        //convert Entity to DTO
        var pedidoResponse = modelMapper.map(pedido,PedidoDTO.class);

        return  new ResponseEntity<PedidoDTO>(pedidoResponse,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@RequestBody PedidoDTO pedidoDto, @PathVariable Long id){

        //convert DTO to Entity
        var pedidoRequest = modelMapper.map(pedidoDto,Pedido.class);
        pedidoRequest.setId(id);

        var pedido = service.updatePedido(pedidoRequest);

        //Entity to DTO
        var pedidoResponse = modelMapper.map(pedido,PedidoDTO.class);
        return ResponseEntity.ok().body(pedidoResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePedido(@PathVariable Long id){
        service.detelePedidoById(id);
    }
}

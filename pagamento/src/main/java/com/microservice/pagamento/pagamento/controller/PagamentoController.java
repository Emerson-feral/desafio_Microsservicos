package com.microservice.pagamento.pagamento.controller;

import com.microservice.pagamento.pagamento.dto.PagamentoDTO;
import com.microservice.pagamento.pagamento.entity.Pagamento;
import com.microservice.pagamento.pagamento.service.PagamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PagamentoDTO> findAllPagamentos(){
        return service.getPagamento().stream()
                .map(pagamento -> modelMapper.map(pagamento,PagamentoDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PagamentoDTO> findPagamentoById(@PathVariable Long id){

        var pagamento = service.getPagamentoById(id);

        // convert DTO to entity
        var pagamentoReponse = modelMapper.map(pagamento,PagamentoDTO.class);

        return  ResponseEntity.ok().body(pagamentoReponse);
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> addPagamento(@RequestBody PagamentoDTO pagamentoDto){

        // convert DTO to entity
        var pagamentoRequest = modelMapper.map(pagamentoDto,Pagamento.class);
        var pagamento = service.savePagamento(pagamentoRequest);

        // convert entity to DTO
        var pagamentoResponse = modelMapper.map(pagamento,PagamentoDTO.class);

        return  new ResponseEntity<PagamentoDTO>(pagamentoResponse,HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PagamentoDTO> updatePagamento(@RequestBody PagamentoDTO pagamentoDto, @PathVariable Long id){

        // convert DTO to Entity
        var pagamentoRequest = modelMapper.map(pagamentoDto,Pagamento.class);
        pagamentoRequest.setId(id);

        var pagamento = service.updatePagamento(pagamentoRequest);

        // entity to DTO
        var pagamentoResponse = modelMapper.map(pagamento,PagamentoDTO.class);
        return  ResponseEntity.ok().body(pagamentoResponse);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePagamento(@PathVariable Long id){
        service.detelePagamentoById(id);
    }

}

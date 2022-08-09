package com.microservice.pagamento.pagamento.controller;

import com.microservice.pagamento.pagamento.entity.Pagamento;
import com.microservice.pagamento.pagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> findAllPagamentos(){
        return service.getPagamento();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pagamento findPagamentoById(@PathVariable Long id){
        return service.getPagamentoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento addPagamento(@RequestBody Pagamento pagamento){
        return service.savePagamento(pagamento);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pagamento updatePagamento(@RequestBody Pagamento pagamento, @PathVariable Long id){
        pagamento.setId(id);
        return service.updatePagamento(pagamento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePagamento(@PathVariable Long id){
        service.detelePagamentoById(id);
    }
}

package com.microservice.pagamento.pagamento.service;

import com.microservice.pagamento.pagamento.entity.Pagamento;
import com.microservice.pagamento.pagamento.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository repository;

    public List<Pagamento> getPagamento() {
        return repository.findAll();
    }

    public Pagamento getPagamentoById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pagamento savePagamento(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    public Pagamento updatePagamento(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    public void detelePagamentoById(Long id) {
        repository.deleteById(id);
    }
}


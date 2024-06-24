package com.example.demo.service;

import com.example.demo.model.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido save(Pedido pedido);

    List<Pedido> findAll();

    Pedido findById(Long id);

    void deleteById(Long id);
}

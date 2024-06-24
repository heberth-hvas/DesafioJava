package com.example.demo.service.impl;

import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido save(Pedido pedido) {
        double imposto = calcularImposto(pedido);
        pedido.setValorTotal(pedido.getValorTotal() + imposto);
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    private double calcularImposto(Pedido pedido) {
        double valorTotal = pedido.getValorTotal();
        if (pedido.getTipo().equalsIgnoreCase("física")) {
            return valorTotal * 0.052;
        } else if (pedido.getTipo().equalsIgnoreCase("jurídica")) {
            return valorTotal * 0.032 + 1;
        }
        return 0;
    }
}

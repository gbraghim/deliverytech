package com.deliverytech.delivery_api.controller;

import com.deliverytech.delivery_api.entity.Pedido;
import com.deliverytech.delivery_api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    // Buscar pedidos de um cliente específico
    @GetMapping("/cliente/{clienteId}")
    public List<Pedido> listarPorCliente(@PathVariable Long clienteId) {
        return pedidoService.listarPorCliente(clienteId);
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }

    // Atualizar status (ex: /pedidos/1/status?novoStatus=ENTREGUE)
    @PatchMapping("/{id}/status")
    public Pedido atualizarStatus(@PathVariable Long id, @RequestParam String novoStatus) {
        return pedidoService.atualizarStatus(id, novoStatus);
    }
}
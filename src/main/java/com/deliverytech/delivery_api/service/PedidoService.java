package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.entity.Pedido;
import com.deliverytech.delivery_api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
    
    public List<Pedido> listarPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public Pedido criarPedido(Pedido pedido) {
        // Regra: Data do pedido é o momento atual
        pedido.setDataHora(LocalDateTime.now());
        
        // Regra: Status inicial
        pedido.setStatus("EM_PREPARO");
        
        // Validação: Pedido deve ter um valor total positivo
        if (pedido.getValorTotal() == null || pedido.getValorTotal() <= 0) {
             throw new RuntimeException("O pedido deve ter um valor total válido.");
        }

        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarStatus(Long id, String novoStatus) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        
        // Aqui poderiam entrar regras, ex: Não pode voltar de "ENTREGUE" para "EM_PREPARO"
        pedido.setStatus(novoStatus);
        
        return pedidoRepository.save(pedido);
    }
}
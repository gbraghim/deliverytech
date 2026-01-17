package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.entity.Cliente;
import com.deliverytech.delivery_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // ✅ O método que estava faltando (ou com erro):
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente salvar(Cliente cliente) {
        // Validação: E-mail único (apenas se for um novo cadastro)
        if (cliente.getId() == null && clienteRepository.findByEmail(cliente.getEmail()) != null) {
            throw new RuntimeException("E-mail já cadastrado!");
        }
        // Regra: Cliente novo nasce ativo por padrão
        if (cliente.getAtivo() == null) {
            cliente.setAtivo(true);
        }
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = buscarPorId(id); // Reusa o método buscarPorId
        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setEndereco(clienteAtualizado.getEndereco());
        // Não atualizamos e-mail ou status aqui para segurança
        return clienteRepository.save(clienteExistente);
    }

    public void inativar(Long id) {
        Cliente cliente = buscarPorId(id); // Reusa o método buscarPorId
        cliente.setAtivo(false); // Soft delete
        clienteRepository.save(cliente);
    }
}
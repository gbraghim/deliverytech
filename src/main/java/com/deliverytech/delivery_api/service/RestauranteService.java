package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.entity.Restaurante;
import com.deliverytech.delivery_api.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    // ✅ Método que estava faltando: listarTodos()
    public List<Restaurante> listarTodos() {
        return restauranteRepository.findAll();
    }

    // Método pedido no AVA: Buscar ativos ordenados por avaliação
    public List<Restaurante> listarAtivos() {
        return restauranteRepository.findByAtivoTrueOrderByAvaliacaoDesc();
    }

    // ✅ Método que estava faltando: buscarPorId(Long id)
    public Restaurante buscarPorId(Long id) {
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
    }

    public Restaurante salvar(Restaurante restaurante) {
        // Regra de negócio: Inicializa avaliação se for nula
        if (restaurante.getAvaliacao() == null) {
            restaurante.setAvaliacao(0.0);
        }
        // Regra de negócio: Inicializa como ativo se for nulo
        if (restaurante.getAtivo() == null) {
            restaurante.setAtivo(true);
        }
        return restauranteRepository.save(restaurante);
    }

    // ✅ Método que estava faltando: alterarStatus(Long id, Boolean ativo)
    public void alterarStatus(Long id, Boolean ativo) {
        Restaurante restaurante = buscarPorId(id);
        restaurante.setAtivo(ativo);
        restauranteRepository.save(restaurante);
    }
}
package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.entity.Produto;
import com.deliverytech.delivery_api.repository.ProdutoRepository;
import com.deliverytech.delivery_api.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private RestauranteRepository restauranteRepository; // Precisa validar se o restaurante existe

    public List<Produto> listarPorRestaurante(Long restauranteId) {
        return produtoRepository.findByRestauranteId(restauranteId);
    }

    public Produto salvar(Produto produto) {
        // Validação: Preço não pode ser negativo ou zero
        if (produto.getPreco() <= 0) {
            throw new RuntimeException("O preço do produto deve ser maior que zero.");
        }

        // Validação: Restaurante deve existir
        if (produto.getRestaurante() == null || produto.getRestaurante().getId() == null) {
            throw new RuntimeException("É obrigatório informar o restaurante do produto.");
        }
        
        // Verifica se o restaurante realmente existe no banco
        boolean restauranteExiste = restauranteRepository.existsById(produto.getRestaurante().getId());
        if (!restauranteExiste) {
             throw new RuntimeException("Restaurante informado não encontrado.");
        }

        if (produto.getDisponivel() == null) {
            produto.setDisponivel(true);
        }

        return produtoRepository.save(produto);
    }
}
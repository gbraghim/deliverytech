package com.deliverytech.delivery_api.controller;

import com.deliverytech.delivery_api.entity.Produto;
import com.deliverytech.delivery_api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Buscar produtos de um restaurante específico
    @GetMapping("/restaurante/{restauranteId}")
    public List<Produto> listarPorRestaurante(@PathVariable Long restauranteId) {
        return produtoService.listarPorRestaurante(restauranteId);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }
    
    // Você pode adicionar outros métodos CRUD aqui se precisar (GET id, DELETE, etc)
}
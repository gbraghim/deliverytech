package com.deliverytech.delivery_api.controller;

import com.deliverytech.delivery_api.entity.Restaurante;
import com.deliverytech.delivery_api.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteService.listarTodos();
    }
    
    @GetMapping("/ativos")
    public List<Restaurante> listarAtivos() {
        return restauranteService.listarAtivos();
    }

    @GetMapping("/{id}")
    public Restaurante buscarPorId(@PathVariable Long id) {
        return restauranteService.buscarPorId(id);
    }

    @PostMapping
    public Restaurante criar(@RequestBody Restaurante restaurante) {
        return restauranteService.salvar(restaurante);
    }

    // Exemplo de atualização de status (PUT ou PATCH)
    @PatchMapping("/{id}/status")
    public void alterarStatus(@PathVariable Long id, @RequestBody Boolean ativo) {
        restauranteService.alterarStatus(id, ativo);
    }
}
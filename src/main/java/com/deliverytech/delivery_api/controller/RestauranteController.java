package com.deliverytech.delivery_api.controller;

import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Define que responde requisições HTTP (API) [cite: 586]
@RequestMapping("/restaurantes") // URL base: http://localhost:8080/restaurantes
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService; // Injeção do Service [cite: 630]

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteService.listarTodos();
    }

    @PostMapping
    public Restaurante adicionar(@RequestBody Restaurante restaurante) {
        return restauranteService.salvar(restaurante);
    }
}
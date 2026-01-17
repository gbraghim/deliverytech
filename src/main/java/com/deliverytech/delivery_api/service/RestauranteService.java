package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired; // Injeção de Dependência [cite: 589]
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Marca a classe de regra de negócio [cite: 587]
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> listarTodos() {
        // Aqui entrariam regras de negócio (ex: filtrar apenas restaurantes ativos)
        return restauranteRepository.findAll();
    }

    public Restaurante salvar(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }
}
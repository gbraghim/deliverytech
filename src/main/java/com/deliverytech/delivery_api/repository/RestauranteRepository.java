package com.deliverytech.delivery_api.repository;

import com.deliverytech.delivery_api.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marca a classe de acesso ao banco [cite: 588]
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    // Só de estender JpaRepository, você já ganha: findAll, save, delete, findById...
}
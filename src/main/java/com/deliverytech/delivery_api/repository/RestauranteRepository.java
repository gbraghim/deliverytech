package com.deliverytech.delivery_api.repository;
import com.deliverytech.delivery_api.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    // Busca por nome, categoria e ordena por avaliação
    List<Restaurante> findByNomeContaining(String nome);
    List<Restaurante> findByCategoria(String categoria);
    List<Restaurante> findByAtivoTrueOrderByAvaliacaoDesc();
}
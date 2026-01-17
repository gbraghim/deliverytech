package com.deliverytech.delivery_api.repository;
import com.deliverytech.delivery_api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email); // Busca por e-mail
    List<Cliente> findByAtivoTrue();   // Busca ativos
}
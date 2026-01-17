package com.deliverytech.delivery_api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    private String status; // EM_PREPARO, SAIU_ENTREGA, ENTREGUE
    private Double valorTotal;

    @ManyToOne
    private Cliente cliente;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
    public Cliente getCliente() { return cliente; }
        public void setCliente(Cliente cliente) { this.cliente = cliente; }
    }
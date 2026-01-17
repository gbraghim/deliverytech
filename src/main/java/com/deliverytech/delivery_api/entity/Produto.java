package com.deliverytech.delivery_api.entity;

import jakarta.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    private Boolean disponivel; // O aviso estava aqui

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    // --- Construtores ---
    public Produto() {}

    public Produto(String nome, Double preco, Boolean disponivel, Restaurante restaurante) {
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
        this.restaurante = restaurante;
    }

    // --- Getters e Setters (Necessários para remover o aviso) ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // ✅ Estes eram os métodos que faltavam para usar o campo 'disponivel':
    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
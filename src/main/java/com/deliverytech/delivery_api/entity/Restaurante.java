package com.deliverytech.delivery_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Define que essa classe é uma tabela no banco [cite: 698]
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipoCozinha;

    // Construtor vazio (obrigatório para JPA)
    public Restaurante() {}

    // Construtor utilitário
    public Restaurante(String nome, String tipoCozinha) {
        this.nome = nome;
        this.tipoCozinha = tipoCozinha;
    }

    // Getters e Setters (Pode usar Lombok @Data se preferir, mas vou deixar explícito)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipoCozinha() { return tipoCozinha; }
    public void setTipoCozinha(String tipoCozinha) { this.tipoCozinha = tipoCozinha; }
}
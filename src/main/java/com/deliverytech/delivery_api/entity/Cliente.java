package com.deliverytech.delivery_api.entity;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String endereco;
    private Boolean ativo;

    // Getters e Setters omitidos para brevidade (Gere na IDE)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public Cliente(Long id, String nome, String email, String endereco, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.ativo = ativo;
    }
}
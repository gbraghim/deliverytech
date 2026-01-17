package com.deliverytech.delivery_api.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Restaurante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private Double avaliacao; // 0.0 a 5.0
    private Boolean ativo;

    // Relacionamento: Um restaurante tem vários produtos
    @OneToMany(mappedBy = "restaurante")
    private List<Produto> produtos;

    // Construtores, Getters e Setters
    public Restaurante() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public Double getAvaliacao() { return avaliacao; }
    public void setAvaliacao(Double avaliacao) { this.avaliacao = avaliacao; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
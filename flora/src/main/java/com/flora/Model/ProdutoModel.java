package com.flora.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    private double precoUnid;

    @JoinColumn(name="id_categoria")
    @ManyToOne
    private CategoriaModel categoria;

    double notaAvaliacao;
    private String urlImagem;


    public ProdutoModel(int id, String nome, double precoUnid, CategoriaModel categoria, double notaAvaliacao, String urlImagem) {
        this.id = id;
        this.nome = nome;
        this.precoUnid = precoUnid;
        this.categoria = categoria;
        this.notaAvaliacao = notaAvaliacao;
        this.urlImagem = urlImagem;
    }

    public ProdutoModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnid() {
        return precoUnid;
    }

    public void setPrecoUnid(double precoUnid) {
        this.precoUnid = precoUnid;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(double notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}

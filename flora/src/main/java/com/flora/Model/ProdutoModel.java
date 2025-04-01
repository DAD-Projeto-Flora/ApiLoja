package com.flora.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class ProdutoModel {
    @Id
    @GeneratedValue
    private int id;
    private String nome;

    @Column(name = "preco_unid")
    private double precoUnid;

    @JoinColumn(name="id_categoria")
    @ManyToOne
    private Categoria idCategoria;

    @Column(name = "nota_avaliacao")
    double notaAvaliacao;

    public ProdutoModel(int id, String nome, double precoUnid, int idCategoria, double notaAvaliacao) {
        this.id = id;
        this.nome = nome;
        this.precoUnid = precoUnid;
        this.idCategoria = idCategoria;
        this.notaAvaliacao = notaAvaliacao;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(double notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    @Override
    public String toString() {
        return "ProdutoModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", precoUnid=" + precoUnid +
                ", idCategoria=" + idCategoria +
                ", notaAvaliacao=" + notaAvaliacao +
                '}';
    }
}

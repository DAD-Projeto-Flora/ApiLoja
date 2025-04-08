package com.flora.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String nome;

    public CategoriaModel(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaModel() {}

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


}

package com.flora.Model;

import jakarta.persistence.*;


@Table(name = "cliente")
@Entity
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nomeCompleto;
    String email;
    String nomeUsuario;
    String fotoPerfil;
    String cpf;
    String genero;
    String senha;
    String telefone;

    public ClienteModel(Long id, String nomeCompleto, String email, String nomeUsuario, String fotoPerfil, String cpf, String genero, String senha, String telefone) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.fotoPerfil = fotoPerfil;
        this.cpf = cpf;
        this.genero = genero;
        this.senha = senha;
        this.telefone = telefone;
    }

    public ClienteModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}


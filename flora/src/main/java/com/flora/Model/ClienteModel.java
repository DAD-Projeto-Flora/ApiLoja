package com.flora.Model;

import jakarta.persistence.*;


@Table(name = "cliente")
@Entity
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nome_completo", nullable = false)
    String nomeCompleto;

    @Column(nullable = false, unique = true)
    String email;

    @Column(name = "nome_usuario", nullable = false, unique = true)
    String nomeUsuario;

    @Column(name = "foto_perfil", length = 1024)
    String fotoPerfil;

    @Column(nullable = false, length = 30)
    String senha;

    @Column(nullable = false, length = 16)
    String telefone;

    public ClienteModel(Long id, String nomeCompleto, String email, String nomeUsuario, String fotoPerfil, String senha, String telefone) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.fotoPerfil = fotoPerfil;
        this.senha = senha;
        this.telefone = telefone;
    }

    public ClienteModel() {}

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

    @Override
    public String toString() {
        return "ClienteModel{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}


package com.flora.Model;

import com.sun.jdi.request.StepRequest;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "cartao")
public class CartaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private ClienteModel cliente;
    private String numero;
    private String cvv;
    private Date validade;
    private String nomeCartao;
    private String apelidoCartao;

    public CartaoModel(Long id, ClienteModel cliente, String numero, String cvv, Date validade, String nomeCartao, String apelidoCartao) {
        this.id = id;
        this.cliente = cliente;
        this.numero = numero;
        this.cvv = cvv;
        this.validade = validade;
        this.nomeCartao = nomeCartao;
        this.apelidoCartao = apelidoCartao;
    }

    public CartaoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getApelidoCartao() {
        return apelidoCartao;
    }

    public void setApelidoCartao(String apelidoCartao) {
        this.apelidoCartao = apelidoCartao;
    }
}

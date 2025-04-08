package com.flora.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Table(name = "pedido")
@Entity
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
    private Long id;
    
    @JoinColumn(name = "id_produto")
    @ManyToOne
    private ProdutoModel produto;

    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private ClienteModel cliente;
    private Date dataPedido;
    private int qntProduto;
    private String formaPgto;
    private Date dataPgto;
    private double precoTotal;


    public PedidoModel(Long id, ProdutoModel produto, ClienteModel cliente, Date dataPedido, int qntProduto, String formaPgto, Date dataPgto, double precoTotal) {
        this.id = id;
        this.produto = produto;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.qntProduto = qntProduto;
        this.formaPgto = formaPgto;
        this.dataPgto = dataPgto;
        this.precoTotal = precoTotal;
    }

    public PedidoModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoModel getproduto() {
        return produto;
    }

    public void setproduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public ClienteModel getcliente() {
        return cliente;
    }

    public void setcliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getQntProduto() {
        return qntProduto;
    }

    public void setQntProduto(int qntProduto) {
        this.qntProduto = qntProduto;
    }

    public String getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(String formaPgto) {
        this.formaPgto = formaPgto;
    }

    public Date getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(Date dataPgto) {
        this.dataPgto = dataPgto;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    @Override
    public String toString() {
        return "PedidoModel{" +
                "id=" + id +
                ", produto=" + produto +
                ", cliente=" + cliente +
                ", dataPedido=" + dataPedido +
                ", qntProduto=" + qntProduto +
                ", formaPgto='" + formaPgto + '\'' +
                ", dataPgto=" + dataPgto +
                ", precoTotal=" + precoTotal +
                '}';
    }
}

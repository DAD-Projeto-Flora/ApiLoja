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

    @Column(name = "id_produto", nullable = false)
    private Long idProduto;

    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    @Column(name = "data_pedido", nullable = false)
    private Date dataPedido;

    @Column(name="qnt_produto", nullable = false)
    private int qntProduto;

    @Column(name = "forma_pgto", nullable = false)
    private String formaPgto;

    @Column(name = "data_pgto", nullable = false)
    private Date dataPgto;

    @Column(name = "preco_total", nullable = false)
    private double precoTotal;


    public PedidoModel(Long id, Long idProduto, Long idCliente, Date dataPedido, int qntProduto, String formaPgto, Date dataPgto, double precoTotal) {
        this.id = id;
        this.idProduto = idProduto;
        this.idCliente = idCliente;
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

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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
                ", idProduto=" + idProduto +
                ", idCliente=" + idCliente +
                ", dataPedido=" + dataPedido +
                ", qntProduto=" + qntProduto +
                ", formaPgto='" + formaPgto + '\'' +
                ", dataPgto=" + dataPgto +
                ", precoTotal=" + precoTotal +
                '}';
    }
}

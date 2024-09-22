package com.example.apibimo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "itempedido")
@Schema(description = "Classe que representa um item de pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do item de pedido")
    private int sid;

    @Column(name = "iquantidade")
    @Schema(description = "Quantidade de produtos no item de pedido")
    @Min(value = 1, message = "A quantidade de produtos deve ser no mínimo 1.")
    private int iQuantidade;

    @Column(name = "fvalor")
    @Schema(description = "Valor total do item de pedido")
    @NotNull(message = "O valor do item é obrigatório")
    private double fValor;

    @Column(name = "idpedido")
    @Schema(description = "Identificador do pedido ao qual o item pertence")
    private int idPedido;

    @Column(name = "idproduto")
    @Schema(description = "Identificador do produto associado ao item")
    private int idProduto;

    @Column(name = "transaction_made")
    @Schema(description = "Indica se a transação foi realizada")
    private boolean transaction_made;


    public ItemPedido(int sid, int iQuantidade, double fValor, int idPedido, int idProduto, boolean transaction_made) {
        this.sid = sid;
        this.iQuantidade = iQuantidade;
        this.fValor = fValor;
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.transaction_made = transaction_made;
    }

    public ItemPedido() {

    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getiQuantidade() {
        return iQuantidade;
    }

    public void setiQuantidade(int iQuantidade) {
        this.iQuantidade = iQuantidade;
    }

    public double getfValor() {
        return fValor;
    }

    public void setfValor(double fValor) {
        this.fValor = fValor;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public boolean isTransactionMade() {
        return transaction_made;
    }

    public void setTransactionMade(boolean transaction_made) {
        this.transaction_made = transaction_made;
    }
}

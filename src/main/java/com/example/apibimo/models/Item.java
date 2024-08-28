package com.example.apibimo.models;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sId;


    @Schema(description = "Atributo responsavel por guardar a quantidade de produtos que tera naquele item ")
    @Size(min = 1, message = "A quantidade de produtos deve conter pelo menos 1 caracter.")
    private int iQuantidade;


    @Schema(description = "Atributo responsavel por trabalhar com informações do valor total to item.")
    @NotNull
    @Size(min = 3, message = "O valor do item deve conter pelo menos 3 caracteres")
    private double fValor;

    @Schema(description = "Atributo responsavel por armazenar qual o pedido que o item faz parte.")
    private int idPedido;

    @Schema(description = "Atributo responsavel por armazenar qual o pedido que o item faz parte.")
    private int idProduto;
}

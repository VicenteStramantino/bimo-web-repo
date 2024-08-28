package com.example.apibimo.models;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Pedido")
@Schema(description = "Esta classe é responsavel por tratar informações de um pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sId;


    @Column(name = "fvalortotal")
    @Schema(description = "Atributo responsavel por trabalhar com o valor total do pedido")
    @Size(min = 3, message = "O preço total deve conter pelo menos 3 caractres.")
    @NotNull
    private double fValorTotal;


    @Column(name = "iquantidade")
    @Schema(description = "Atributo responsavel por guardar e exibir a quantidade de produtos no pedido")
    @Size(min = 1, message = "A quantidade deve conter pelo menos 1 caracter.")
    @NotNull
    private int iQuantidade;


    @Schema(description = "Atributo responsavel por guardar a data em que o pedido esta sendo realizado.")
    @Size(min = 10, message = "O campo data deve conter pelo menos 10 caractres.")
    @NotNull
    private String dData;


    @Schema(description = "Atributo responsavel por trabalhar, ou seja, se o pedido ja foi realizado ou nao")
    @Size(min = 4, message = "O campo status deve conter pelo menos 4 caractres.")
    @NotNull
    private String cStatus;

}

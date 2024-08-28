package com.example.apibimo.models;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Produto")
@Schema(description = "Esta classe representa um produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sId;


    @Schema(description = "Atributo responsavel por pegar e exibir estado de onde o produto esta sendo enviado.")
    @Size(min = 4, message = "O estado deve conter deve conter no minimo 4 caractres")
    private String cEstado;

    @NotNull
    @Schema(description = "Atributo onde ficara armazenado o nome do usuario")
    @Size(min = 3, message = "O nome do produto deve conter no minimo 4 caractres")
    private String cNome;


    @Column(name = "fpreco")
    @NotNull
    @Schema(description = "Atributo onde ficara armazenado o preço de um produto.")
    @Size(min = 3, message = "O preço deve conter no minimo 3 caractres")
    private double fPreco;

    @Schema(description = "Este atributo é responsavel por guardar a descrição do produto.")
    @Size(min = 4, message = "Este campo deve conter no minimo 4 caractres")
    private String cDescricao;


    @NotNull
    @Schema(description = "Esta classe guardara a categoria do produto")
    @Size(min = 4, message = "Este campo deve conter no minimo 4 caractres")
    private String cCategoria;


}

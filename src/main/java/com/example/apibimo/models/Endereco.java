package com.example.apibimo.models;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Endereco")
@Schema(description = "Classe que representa um endereco")
public class Endereco{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sId;


    @Schema(description = "Atributo que armazenara o CEP do usuario.")
    @Size(min = 10, max = 10, message = "O CEP deve conter 10 caracteres")
    private String cCep;


    @Schema(description = "Atributo que ficara guarado o bairro do usuario.")
    @Size(min = 5, max = 50,message = "O bairro deve conter no minimo 5 e no maximo 50 caracteres.")
    private String cBairro;


    @Column(name = "inumero")
    @Schema(description = "Atributo que ficara armazenado o numero de residencia do usuario.")
    @Size(min = 1, max = 6, message = "O numero da residencia deve conter no minimo um caracter e no maximo 6 caracteres")
    private int iNumero;


    @Column(name = "idestado")
    @Schema(description = "Atributo que armazenara o estado do usuario.")
    @Size(min = 4, max = 30, message = "O nome do estado deve conter no minimo 4 caracteres e no maximo 30 caracteres.")
    @NotNull
    private int idEstado;



    @Schema(description = "Atributo que armazenara a rua do usuario.")
    @Size(min = 3, max = 150, message = "O nome da rua deve conter no minimo 3 caracteres e no maximo 150 caracteres.")
    private String cRua;


    @Column(name = "idusuario")
    @Schema(description = "Atributo que sera responsavel por guardar o id do usuario.")
    private int idUsuario;
}

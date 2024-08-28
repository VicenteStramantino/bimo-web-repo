package com.example.apibimo.models;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Curso")
@Schema(description = "Classe usada para representar um curso.")
public class Curso {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sId;


    @Column(name = "fvalor")
    @Schema(description = "Atributo utilizado para armazenar o valor do curso.")
    @NotNull
    @Size(min = 3, message = "O valor do curso deve conter pelo menos 3 caracteres.")
    private double fValor;


    @Column(name = "cdescricao")
    @NotNull
    @Schema(description = "Atributo utilizado para armazenar a descrição do curso.")
    @Size(min = 3, message = "A descrição do curso deve conter pelo menos 3 caracteres.")
    private String cDescricao;


    @Column(name = "ccertificacao")
    @NotNull
    @Schema(description = "Atributo que guarda link onde contenha a certificação do curso.")
    @Size(min = 3, message = "Este campo deve conter pelo menos 3 caracteres.")
    private String cCertificacao;


    @Column(name = "ccategoria")
    @NotNull
    @Schema(description = "Atributo que guarda a categoria do curso.")
    @Size(min = 3, message = "A categoria deve conter pelo menos 3 caracteres.")
    private String cCategoria;


    @Column(name = "inumeroinscricao")
    @NotNull
    @Schema(description = "Atributo onde fica armazenado a quantidade de pessoas inscritas no curso.")
    @Size(min = 1, message = "O numeros de inscritos deve conter pelo menos 1 caracter")
    private int iNumeroInscricao;


    @Column(name = "cnome")
    @NotNull
    @Schema(description = "Atributo que guarda o nome do curso.")
    @Size(min = 4, message = "O nome do curso deve conter pelo menos 4 caracteres.")
    private String cNome;


    @Column(name = "cduracao")
    @NotNull
    @Schema(description = "Atributo que armazena a duração que o curso tem.")
    @Size(min = 5, message = "O campo de duração do curso, deve conter pelo menos 5 caracteres.")
    private String cDuracao;


    @Column(name = "idusuario")
    @Schema(description = "Atributo que indica qual usuario esta oferecendo aquele curso.")
    private int idUsuario;
}

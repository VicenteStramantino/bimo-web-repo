package com.example.apibimo.models;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "usuario")
@Schema(description = "Representa um usuario no sistema")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @NotNull
    @Size(min = 2,message = "O nome deve ter no minimo 2 caracteres")
    @Schema(description = "Nome do usuário")
    private String cnome;

    @NotNull
    @Size(min = 3, message = "O sobrenome deve ter mai que 3 caracteres")
    @Schema(description = "Sobrenome utilizado pelo usuario")
    private String csobrenome;


    @NotNull
    @Size(min = 4, message = "A senha deve conter pelo menos 4 caracteres.")
    @Schema(description = "Senha utilizada pelo usuario para logar.")
    private String csenha;

    @NotNull
    @Size(min = 11, message = "Um caracter deve conter no minimo 11 caracteres.")
    @Schema( description = "Cpf ligado a conta do usuário.")
    @CPF
    private String ccpf;

    @NotNull
    @Size(min = 7, message = "O email deve ter no Minimo 7 caracteres")
    @Schema(description = "E-mail ligada a conta do usuario")
    @Email
    private String cemail;


    @NotNull
    @Size(min = 14, message = "O CNPJ deve ter no minimo 14 caracteres.")
    @CNPJ
    @Schema(description = "Caso o usuario seja uma empresa, este campo ira guardar o CNPJ da empresa")
    private String ccnpj;


    @NotNull
    @Size(min = 11, message = "Um telefone deve ter no minimo 11 caracteres.")
    @Schema(description = "Telefone de contado que estara presente na conta do usuario")
    private String ctelefone;

    @NotNull
    @Size(min = 10, message = "A data de nascimento deve ter no minimo 10 caracteres")
    @Schema(description = "Data de nascimento do usuario.")
    private String ddatanascimento;


    @NotNull
    @Size(min = 8, message = "O link deve ter no minimo 8 caracteres")
    @Schema(description = "Atributo onde ficaria guardado o link do Linkedin do usuário.")
    private String  clinklinkedin;


    @NotNull
    @Schema(description = "Atributo onde ficaria guardado o hash para login do usuario. Este hash vira do database")
    private String  cidhash;






}

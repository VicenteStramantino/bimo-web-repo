package com.example.apibimo.models;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Curriculo")
@Schema(description = "Representa o curriculo de um usuario no sistema")
public class Curriculo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sId;


    @Column(name = "cLink_Linkedin")
    @Size(min = 4, message = "O campo deve ter pelo menos 4 caracteres.")
    @Schema(description = "Local onde ficara guarado o link do linkedin do usuario")
    private String cLinkLinkedin;

    @Size(min = 5, message = "O campo habilidades deve conter pelo menos 5 caracteres")
    @Schema(description = "Atributo onde ficara guardado todas as habilidiades do usuario." )
    private String cHabilidades;


    @Column(name = "dData_Criacao")
    @Schema(description = "Atributo que sera usado para pegar a data de criação daquele curriculo")
    @Size(min = 10, message = "O campo deve haver 10 caracteres.")
    private String dDataCriacao;

    @Column(name = "cData_Atualizacao")
    @Schema(description = "Atributo que sera usado para pegar a data de atualização daquele curriculo")
    @Size(min = 10, message = "O campo deve haver 10 caracteres.")
    private String cDataAtualizacao;


    @Column(name = "ctelefone")
    @Size(min = 10, max = 20, message = "O telefone deve ter no minimo 10 caracteres e no maximo 20 caracteres")
    @NotNull
    @Schema(description = "Atributo usado ara representar o telefone de contado do usuario que estara presente no curriculo")
    private String cTelefone;

    @Column(name = "cinfosgerais")
    @Schema(description = "Campo que sera utilizado para pegar as informações gerais do usuario.")
    @NotNull
    @Size(min = 5, message = "O campo deve conter pelo menos 5 caracteres")
    private String cInfosGerais;


    @Schema(description = "Atributo utilizado para armazenar projetos ja feitos pelo usuario. Como por exemplo, links de repositorios do github onde fez parte.")
    @Size(min = 4, message = "O campo deve conter pelo menos 4 caracteres.")
    private String cProjetos;

    public long getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getcLinkLinkedin() {
        return cLinkLinkedin;
    }

    public void setcLinkLinkedin(String cLinkLinkedin) {
        this.cLinkLinkedin = cLinkLinkedin;
    }

    public String getcHabilidades() {
        return cHabilidades;
    }

    public void setcHabilidades(String cHabilidades) {
        this.cHabilidades = cHabilidades;
    }

    public String getdDataCriacao() {
        return dDataCriacao;
    }

    public void setdDataCriacao(String dDataCriacao) {
        this.dDataCriacao = dDataCriacao;
    }

    public String getcDataAtualizacao() {
        return cDataAtualizacao;
    }

    public void setcDataAtualizacao(String cDataAtualizacao) {
        this.cDataAtualizacao = cDataAtualizacao;
    }

    public String getcTelefone() {
        return cTelefone;
    }

    public void setcTelefone(String cTelefone) {
        this.cTelefone = cTelefone;
    }

    public String getcInfosGerais() {
        return cInfosGerais;
    }

    public void setcInfosGerais(String cInfosGerais) {
        this.cInfosGerais = cInfosGerais;
    }

    public String getcProjetos() {
        return cProjetos;
    }

    public void setcProjetos(String cProjetos) {
        this.cProjetos = cProjetos;
    }
}

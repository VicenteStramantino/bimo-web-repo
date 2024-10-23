package com.example.apibimo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "curso")
@Schema(description = "Classe que representa um curso com detalhes como valor, descrição e certificação.")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do curso.", example = "1")
    private int sid;

    @Column(name = "fvalor")
    @Schema(description = "Valor do curso em reais.", example = "199.99")
    @NotNull
    private double fValor;

    @Column(name = "cdescricao")
    @Schema(description = "Descrição do curso.", example = "Curso de Programação em Java.")
    @NotNull
    private String cDescricao;

    @Column(name = "ccertificacao")
    @Schema(description = "Link para a certificação do curso.", example = "http://example.com/certificacao")
    @NotNull
    private String cCertificacao;

    @Column(name = "idcategoria")
    @Schema(description = "Categoria do curso. Exemplo: 1 para Tecnologia, 2 para Negócios.", example = "1")
    @NotNull
    private int iCategoria;

    @Column(name = "inumeroinscricao")
    @Schema(description = "Número de pessoas inscritas no curso.", example = "50")
    @NotNull
    private int iNumeroInscricao;

    @Column(name = "cnome")
    @Schema(description = "Nome do curso.", example = "Desenvolvimento Web com Spring Boot")
    @NotNull
    private String cNome;

    @Column(name = "cduracao")
    @Schema(description = "Duração do curso em horas.", example = "40")
    @NotNull
    private String cDuracao;


    @Schema(description = "URL da foto do curso")
    private String curlfoto;

    public Curso(int sid, double fValor, String cDescricao, String cCertificacao, int iCategoria, int iNumeroInscricao, String cNome, String cDuracao, String curlfoto) {
        this.sid = sid;
        this.fValor = fValor;
        this.cDescricao = cDescricao;
        this.cCertificacao = cCertificacao;
        this.iNumeroInscricao = iNumeroInscricao;
        this.cNome = cNome;
        this.cDuracao = cDuracao;
        this.iCategoria = iCategoria;
        this.curlfoto = curlfoto;

    }

    public Curso() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public double getfValor() {
        return fValor;
    }

    public void setfValor(double fValor) {
        this.fValor = fValor;
    }

    public String getcDescricao() {
        return cDescricao;
    }

    public void setcDescricao(String cDescricao) {
        this.cDescricao = cDescricao;
    }

    public String getcCertificacao() {
        return cCertificacao;
    }

    public void setcCertificacao(String cCertificacao) {
        this.cCertificacao = cCertificacao;
    }

    public int getcCategoria() {
        return iCategoria;
    }

    public void setcCategoria(int cCategoria) {
        this.iCategoria = cCategoria;
    }

    public int getiNumeroInscricao() {
        return iNumeroInscricao;
    }

    public void setiNumeroInscricao(int iNumeroInscricao) {
        this.iNumeroInscricao = iNumeroInscricao;
    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome;
    }

    public String getcDuracao() {
        return cDuracao;
    }

    public void setcDuracao(String cDuracao) {
        this.cDuracao = cDuracao;
    }

    public int getiCategoria() {
        return iCategoria;
    }

    public void setiCategoria(int iCategoria) {
        this.iCategoria = iCategoria;
    }

    public String getCurlfoto() {
        return curlfoto;
    }

    public void setCurlfoto(String curlfoto) {
        this.curlfoto = curlfoto;
    }
}

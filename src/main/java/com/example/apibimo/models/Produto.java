package com.example.apibimo.models;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produto")
@Schema(description = "Esta classe representa um produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;


//    @Column(name = "idestado")
//    @Schema(description = "Atributo responsavel por fazer ligação com a tabela de estado")
//    @Size(min = 4, message = "O estado deve conter deve conter no minimo 4 caractres")
//    private int idEstado;


    @Column(name = "cnome")
    @NotNull
    @Schema(description = "Atributo onde ficara armazenado o nome do usuario")
    @Size(min = 3, message = "O nome do produto deve conter no minimo 4 caractres")
    private String cNome;


    @Column(name = "fvalor")
    @NotNull
    @Schema(description = "Atributo onde ficara armazenado o preço de um produto.")
//    @Size(min = 3, message = "O preço deve conter no minimo 3 caractres")
    private double fvalor;


    @Column(name = "cdescricao")
    @Schema(description = "Este atributo é responsavel por guardar a descrição do produto.")
    @Size(min = 4, message = "Este campo deve conter no minimo 4 caractres")
    private String cDescricao;


    @Column(name = "idcategoria")
    @NotNull
    @Schema(description = "Atribuo responsavel por fazer a ligação com a tabela de categoria")
    private int idCategoria;


    @Column(name = "idusuario")
    @NotNull
    @Schema(description = "Atribuo responsavel por fazer a ligação com a tabela de usuario")
    private int idUsuario;


    @Column(name = "ddatacriacao")
    @NotNull
    @Schema(description = "Atribuo responsavel por guardar a data de criação do produto")
    @Size(min = 10, message = "Este campo deve conter no minimo 10 caractres")
    private String dDataCriacao;

    @Column(name = "transaction_made")
    @Schema(description = "Atributo que sera responsavel por ajudar na organização do banco")
    private boolean transaction_made;

    public Produto() {
    }

    public Produto(int sid, String cNome, double fvalor, String cDescricao, int idCategoria, int idUsuario ,String dDataCriacao) {
        this.sid = sid;
        this.cNome = cNome;
        this.fvalor = fvalor;
        this.cDescricao = cDescricao;
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
        this.dDataCriacao = dDataCriacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome;
    }

    public double getFvalor() {
        return fvalor;
    }

    public void setFvalor(double fvalor) {
        this.fvalor = fvalor;
    }

    public String getcDescricao() {
        return cDescricao;
    }

    public void setcDescricao(String cDescricao) {
        this.cDescricao = cDescricao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getdDataCriacao() {
        return dDataCriacao;
    }

    public void setdDataCriacao(String dDataCriacao) {
        this.dDataCriacao = dDataCriacao;
    }

    public boolean isTransaction_made() {
        return transaction_made;
    }

    public void setTransaction_made(boolean transaction_made) {
        this.transaction_made = transaction_made;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "sid=" + sid +
                ", cNome='" + cNome + '\'' +
                ", fvalor=" + fvalor +
                ", cDescricao='" + cDescricao + '\'' +
                ", idCategoria=" + idCategoria +
                ", dDataCriacao='" + dDataCriacao + '\'' +
                ", transaction_made=" + transaction_made +
                '}';
    }
}

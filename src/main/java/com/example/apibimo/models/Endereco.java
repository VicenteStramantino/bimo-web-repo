package com.example.apibimo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "endereco")
@Schema(description = "Classe que representa um endereço, armazenando informações detalhadas sobre o CEP, rua, bairro, estado e número de residência do usuário.")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do endereço.", example = "1")
    private int sid;

    @Column(name = "ccep")
    @Schema(description = "CEP do usuário, que deve ter exatamente 10 caracteres.", example = "12345-6789")
    @Size(min = 9, max = 10, message = "O CEP deve conter 10 caracteres.")
    private String cCep;

    @Column(name = "cbairro")
    @Schema(description = "Nome do bairro do usuário, com mínimo de 5 e máximo de 50 caracteres.", example = "Centro")
    @Size(min = 5, max = 50, message = "O bairro deve conter no mínimo 5 e no máximo 50 caracteres.")
    private String cBairro;

    @Column(name = "inumero")
    @Schema(description = "Número da residência do usuário, com mínimo de 1 e máximo de 6 caracteres.", example = "123")
    @NotNull(message = "O número da residência é obrigatório.")
    private int iNumero;

    @Column(name = "crua")
    @Schema(description = "Nome da rua do usuário, com mínimo de 3 e máximo de 150 caracteres.", example = "Rua das Flores")
    @Size(min = 3, max = 150, message = "O nome da rua deve conter no mínimo 3 e no máximo 150 caracteres.")
    private String cRua;

    @Column(name = "idusuario")
    @Schema(description = "Identificador do usuário associado a este endereço.", example = "101")
    private int idUsuario;

    @Column(name = "cestado")
    @Schema(description = "Nome do estado associado ao endereço.", example = "São Paulo")
    private String cEstado;

    public Endereco(int sid, String cCep, String cBairro, int iNumero, String cRua, int idUsuario, String cEstado) {
        this.sid = sid;
        this.cCep = cCep;
        this.cBairro = cBairro;
        this.iNumero = iNumero;
        this.cRua = cRua;
        this.idUsuario = idUsuario;
        this.cEstado = cEstado;
    }
    public Endereco( String cCep, String cBairro, int iNumero, String cRua, int idUsuario, String cEstado) {
        this.cCep = cCep;
        this.cBairro = cBairro;
        this.iNumero = iNumero;
        this.cRua = cRua;
        this.idUsuario = idUsuario;
        this.cEstado = cEstado;
    }


    public Endereco(){

    }
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getcCep() {
        return cCep;
    }

    public void setcCep(String cCep) {
        this.cCep = cCep;
    }

    public String getcBairro() {
        return cBairro;
    }

    public void setcBairro(String cBairro) {
        this.cBairro = cBairro;
    }

    public int getiNumero() {
        return iNumero;
    }

    public void setiNumero(int iNumero) {
        this.iNumero = iNumero;
    }



    public String getcRua() {
        return cRua;
    }

    public void setcRua(String cRua) {
        this.cRua = cRua;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getcEstado() {
        return cEstado;
    }

    public void setcEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "sid=" + sid +
                ", cCep='" + cCep + '\'' +
                ", cBairro='" + cBairro + '\'' +
                ", iNumero=" + iNumero +
                ", cRua='" + cRua + '\'' +
                ", idUsuario=" + idUsuario +
                ", cEstado='" + cEstado + '\'' +
                '}';
    }
}

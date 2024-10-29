package com.example.apibimo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pedido")
@Schema(description = "Classe responsável por tratar informações de um pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do pedido", example = "1")
    private int sid;

    @Column(name = "fvalortotal")
    @Schema(description = "Valor total do pedido", example = "150.75")
    @Min(value = 0, message = "O valor total deve ser positivo.")
    @NotNull(message = "O valor total é obrigatório.")
    private double fValorTotal;


    @Column(name = "ddata")
    @Schema(description = "Data em que o pedido está sendo realizado", example = "2024-09-17")
    @Size(min = 10, max = 10, message = "A data deve seguir o formato YYYY-MM-DD.")
    @NotNull(message = "A data é obrigatória.")
    private String dData;

    @Column(name = "cstatus")
    @Schema(description = "Status do pedido (realizado ou não)", example = "PENDENTE")
    @Size(min = 4, message = "O status deve conter pelo menos 4 caracteres.")
    @NotNull(message = "O status é obrigatório.")
    private String cStatus;

    @Column(name = "ctipopagamento")
    @Schema(description = "Tipo de pagamento utilizado no pedido", example = "CARTÃO")
    @Size(min = 3, message = "O tipo de pagamento deve conter pelo menos 3 caracteres.")
    @NotNull(message = "O tipo de pagamento é obrigatório.")
    private String cTipoPagamento;


    @Column(name = "idusuario")
    @Schema(description = "Atributo FK da tabela de usuario", example ="1")
    private int iIdUsuario;

        public Pedido(double fValorTotal, String dData, String cStatus, String cTipoPagamento, int idusuario) {
            this.fValorTotal = fValorTotal;
            this.dData = dData;
            this.cStatus = cStatus;
            this.cTipoPagamento = cTipoPagamento;
            this.iIdUsuario = idusuario;
        }

    // Construtor padrão
    public Pedido() {
    }

    // Getters e Setters
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public double getfValorTotal() {
        return fValorTotal;
    }

    public void setfValorTotal(double fValorTotal) {
        this.fValorTotal = fValorTotal;
    }


    public String getdData() {
        return dData;
    }

    public void setdData(String dData) {
        this.dData = dData;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public String getcTipoPagamento() {
        return cTipoPagamento;
    }

    public void setcTipoPagamento(String cTipoPagamento) {
        this.cTipoPagamento = cTipoPagamento;
    }

    public int getiIdUsuario() {
        return iIdUsuario;
    }

    public void setiIdUsuario(int iIdUsuario) {
        this.iIdUsuario = iIdUsuario;
    }

}

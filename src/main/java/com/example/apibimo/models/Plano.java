package com.example.apibimo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "plano")
@Schema(description = "Classe usada para representar um plano.")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @NotNull
    @Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres")
    @Schema(description = "Nome do plano")
    private String cnome;

    @NotNull
    @Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres")
    @Schema(description = "Descrição do plano")
    private String cdescricao;

    public Plano(int sid, String cnome, String cdescricao) {
        this.sid = sid;
        this.cnome = cnome;
        this.cdescricao = cdescricao;
    }

    public Plano() {

    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getCnome() {
        return cnome;
    }

    public void setCnome(String cnome) {
        this.cnome = cnome;
    }

    public String getCdescricao() {
        return cdescricao;
    }

    public void setCdescricao(String cdescricao) {
        this.cdescricao = cdescricao;
    }

    @Override
    public String toString() {
        return "{" +
                "sid=" + sid +
                ", cnome='" + cnome + '\'' +
                ", cdescricao='" + cdescricao + '\'' +
                '}';
    }
}

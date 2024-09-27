package com.example.apibimo.models;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
@Schema(description = "Classe usada para representar uma categoria.")
public class Categoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @Column(name = "cnome")
    @Schema(description = "Atributo que guarda o nome da categoria")
    private String cNome;


    @Column(name = "ctipo")
    @Schema(description = "Mostra o tipo da categoria, util para organização")
    private String cTipo;

    public Categoria(int sid, String cNome, String cTipo) {
        this.sid = sid;
        this.cNome = cNome;
        this.cTipo = cTipo;
    }

    public Categoria() {

    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome;
    }

    public String getcTipo() {
        return cTipo;
    }

    public void setcTipo(String cTipo) {
        this.cTipo = cTipo;
    }

    @Override
    public String toString() {
        return "{" +
                "sid=" + sid +
                ", cNome='" + cNome + '\'' +
                ", cTipo='" + cTipo + '\'' +
                '}';
    }
}

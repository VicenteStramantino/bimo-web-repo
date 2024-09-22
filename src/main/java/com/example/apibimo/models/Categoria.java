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
    private String cnome;


    @Column(name = "transaction_made")
    @Schema(description = "atributo utilizado para organização do banco de dados")
    private boolean transaction_made;


}

package com.example.apibimo.controllers;


import com.example.apibimo.services.CategoriaService;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apibimo/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    private final Validator validator;

    public CategoriaController(CategoriaService categoriaService, Validator validator) {
        this.categoriaService = categoriaService;
        this.validator = validator;
    }

}

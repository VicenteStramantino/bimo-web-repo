package com.example.apibimo.controllers;


import com.example.apibimo.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.Validator;
@RestController
    @RequestMapping("/apibimo/cursos")
public class CursoController{

    private CursoService cursoService;

    private final Validator validator;

    @Autowired
    public CursoController(CursoService cursoService, Validator validator) {
        this.cursoService = cursoService;
        this.validator = validator;
    }

}

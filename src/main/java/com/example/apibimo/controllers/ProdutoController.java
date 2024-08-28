package com.example.apibimo.controllers;


import com.example.apibimo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.Validator;


@RestController
@RequestMapping("/apibimo/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    private final Validator validator;


    @Autowired
    public ProdutoController(ProdutoService produtoService, Validator validator){
        this.produtoService = produtoService;
        this.validator = validator;
    }
}

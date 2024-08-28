package com.example.apibimo.controllers;

import com.example.apibimo.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apibimo/enderecos")
public class EnderecoController {
    private EnderecoService enderecoService;

    private final Validator validator;

    @Autowired
    public EnderecoController(EnderecoService enderecoService, Validator validator) {
        this.enderecoService = enderecoService;
        this.validator = validator;
    }
}

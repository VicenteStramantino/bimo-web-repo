package com.example.apibimo.controllers;

import com.example.apibimo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apibimo/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;

    private final Validator validator;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, Validator validator) {
        this.usuarioService = usuarioService;
        this.validator = validator;
    }
}

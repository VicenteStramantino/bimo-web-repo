package com.example.apibimo.controllers;


import com.example.apibimo.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.Validator;


@RestController
@RequestMapping("/apibimo/pedidos")
class PedidoController {

    private PedidoService pedidoService;

    private Validator validator;


    @Autowired
    public PedidoController(PedidoService pedidoService, Validator validator) {
        this.pedidoService = pedidoService;
        this.validator = validator;
    }
}

package com.example.apibimo.controllers;

import com.example.apibimo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apibimo/itens")
public class ItemController {

    private ItemService itemService;

    private final Validator validator;

    @Autowired
    public ItemController(ItemService itemService, Validator validator) {
        this.itemService = itemService;
        this.validator = validator;
    }
}

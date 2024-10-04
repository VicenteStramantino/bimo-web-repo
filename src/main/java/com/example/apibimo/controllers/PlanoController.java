package com.example.apibimo.controllers;

import com.example.apibimo.models.Plano;
import com.example.apibimo.services.PlanoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apibimo/planos")
public class PlanoController {

    private final PlanoService planoService;

    @Autowired
    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @GetMapping("/selecionarTodos")
    @Operation(summary = "Mostra todos os planos disponíveis", description = "Retorna uma lista de todos os planos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de planos retornada com sucesso.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Plano.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public List<Plano> listarPlanos() {
        return planoService.buscarTodosPlanos();
    }

    @GetMapping("/selecionarPorID/{id}")
    @Operation(summary = "Obtém um plano por ID", description = "Este endpoint retorna o plano correspondente ao ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano retornado com sucesso.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Plano.class))),
            @ApiResponse(responseCode = "404", description = "Plano não encontrado com o ID fornecido.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public Plano buscarPlanoPorID(@PathVariable int id) {
        return planoService.buscarPlanoPorID(id);
    }
}

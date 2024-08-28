package com.example.apibimo.controllers;

import com.example.apibimo.models.Curriculo;
import com.example.apibimo.services.CurriculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apibimo/curriculos")
public class CurriculoController {
    private CurriculoService curriculoService;

    private final Validator validator;

    @Autowired
    public CurriculoController(CurriculoService curriculoService, Validator validator) {
        this.curriculoService = curriculoService;
        this.validator = validator;
    }

    @GetMapping("/selecionar")
    @Operation(summary = "procura todos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de todos os curriculos",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Curriculo.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public List<Curriculo> listarTodos(){
        return curriculoService.buscarTodos();
    }


    @DeleteMapping("/excluir/{id}")
    @Schema(description = "Metodo que exclui curriculos",example = "Excluir curriculo 1")
    public ResponseEntity<String> excluir(@PathVariable long id){
        if(id < 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro, o id deve ser maior que zero");
        }
        else{
            curriculoService.deletar(id);
            return ResponseEntity.status(HttpStatus.OK).body("Curriculo excluido com sucesso");
        }
    }
}

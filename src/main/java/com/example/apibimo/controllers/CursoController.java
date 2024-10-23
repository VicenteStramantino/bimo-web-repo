package com.example.apibimo.controllers;

import com.example.apibimo.models.Curso;
import com.example.apibimo.services.CursoService;
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
@RequestMapping("/apibimo/cursos")
public class CursoController {

    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/selecionarTodos")
    @Operation(summary = "Mostra todos cursos disponíveis",
            description = "Retorna uma lista de todos os cursos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de cursos retornada com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public List<Curso> listarCursos() {
        return cursoService.buscarTodosCursos();
    }

    @GetMapping("/selecionarPorID/{id}")
    @Operation(summary = "Obtém um curso por ID",
            description = "Este endpoint retorna o curso correspondente ao ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso retornado com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado com o ID fornecido.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public Curso buscarCursoPorID(@PathVariable int id) {
        return cursoService.buscarCursoPorID(id);
    }


}

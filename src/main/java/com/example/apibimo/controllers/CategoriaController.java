package com.example.apibimo.controllers;

import com.example.apibimo.models.Categoria;
import com.example.apibimo.services.CategoriaService;
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
@RequestMapping("/apibimo/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/selecionarTodos")
    @Operation(summary = "Mostra todas as categorias disponíveis",
            description = "Retorna uma lista de todas as categorias cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public List<Categoria> listarCategorias() {
        return categoriaService.buscarTodasCategorias();
    }

    @GetMapping("/selecionarPorID/{id}")
    @Operation(summary = "Obtém uma categoria por ID",
            description = "Este endpoint retorna a categoria correspondente ao ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria retornada com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class))),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada com o ID fornecido.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public Categoria buscarCategoriaPorID(@PathVariable int id) {
        return categoriaService.buscarCategoriaPorID(id);
    }

    @PostMapping("/inserir")
    @Operation(summary = "Insere uma nova categoria",
            description = "Este endpoint insere uma nova categoria com as informações fornecidas no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria inserida com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class))),
            @ApiResponse(responseCode = "400", description = "Erro de validação dos dados fornecidos.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public ResponseEntity<?> inserirCategoria(@Valid @RequestBody Categoria categoria, BindingResult erros) {
        if (erros.hasErrors()) {
            Map<String, String> errosTotais = new HashMap<>();
            for (FieldError erro : erros.getFieldErrors()) {
                errosTotais.put(erro.getField(), erro.getDefaultMessage());
            }
            return new ResponseEntity<>(errosTotais, HttpStatus.BAD_REQUEST);
        }
        categoriaService.inserirCategoria(categoria);
        return new ResponseEntity<>("Categoria inserida com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{ids}")
    @Operation(summary = "Exclui categorias",
            description = "Este endpoint exclui as categorias correspondentes aos IDs fornecidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categorias excluídas com sucesso.",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public ResponseEntity<String> excluirCategoria(@PathVariable("ids") int[] ids) {
        return categoriaService.deletarCategorias(ids);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza uma categoria existente",
            description = "Este endpoint atualiza as informações da categoria com o ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class))),
            @ApiResponse(responseCode = "400", description = "Erro de validação dos dados fornecidos.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada com o ID fornecido.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public ResponseEntity<String> atualizarCategoria(@PathVariable int id, @Valid @RequestBody Categoria categoriaAtualizada, BindingResult resultado) {
        return categoriaService.atualizarCategoria(id, categoriaAtualizada);
    }

}

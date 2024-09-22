package com.example.apibimo.controllers;


import com.example.apibimo.models.Produto;
import com.example.apibimo.services.ProdutoService;
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
import org.springframework.validation.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @GetMapping("/selecionarTodos")
    @Operation(summary = "procura produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public List<Produto> listarProdutos(){
        return produtoService.buscarTodosProdutos();
    }


    @GetMapping("/selecionarPorID/{id}")
    @Schema(description = "Busca os produtos por id", example = "buscar maquina de lavar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto retornado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public Produto BuscarProdutosPorNome(@PathVariable int id){
        return produtoService.buscarProdutoPorID(id);
    }


    @PostMapping("/inserir")
    @Operation(summary = "Insere produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto inserido com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    @Schema(description = "Metodo que insere produtos",example = "inserir maquina de lavar")
    public ResponseEntity<?> inserirProdutos(@Valid @RequestBody Produto produto, BindingResult erros) {
        if(erros.hasErrors()){
            Map<String, String> errosTotais = new HashMap<>();
            for (FieldError erro : erros.getFieldErrors()) {
                // Coloque o nome do campo e a mensagem de erro no mapa
                errosTotais.put(erro.getField(), erro.getDefaultMessage());
            }
            return new ResponseEntity<>(errosTotais, HttpStatus.BAD_REQUEST);
        }
        produtoService.inserirProdutos(produto);
        return new ResponseEntity<>("Produto inserido com sucesso.", HttpStatus.OK);
    }


    @DeleteMapping("/deletar/{ids}")
    @Schema(description = "Metodo que deleta produtos",example = "excluir hamburguer de frango")
    @Operation(summary = "Deleta produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<String> excluirProduto(@PathVariable("ids") int[] ids){
        return produtoService.deletar(ids);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto alterado com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    @Schema(description = "Metodo que altera um produto",example = "alterar maquina de lavar")
    public ResponseEntity<String> atualizaProduto(@PathVariable int id, @Valid @RequestBody Produto produtoAtualizado, BindingResult resultado){
        return produtoService.atualiza(id, produtoAtualizado);
    }
}

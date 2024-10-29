package com.example.apibimo.controllers;

import com.example.apibimo.models.ItemPedido;
import com.example.apibimo.services.ItemService;
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
@RequestMapping("/apibimo/itempedidos")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/selecionarTodos")
    @Operation(summary = "Procura todos os itens de pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de itens de pedido retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ItemPedido.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public List<ItemPedido> listarItensPedido() {
        return itemService.buscarTodosItensPedido();
    }

    @GetMapping("/selecionarPorID/{id}")
    @Schema(description = "Busca item de pedido por ID", example = "Buscar item de pedido com ID 1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item de pedido retornado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ItemPedido.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ItemPedido buscarItemPedidoPorID(@PathVariable int id) {
        return itemService.buscarItemPedidoPorID(id);
    }

    @PostMapping("/inserir")
    @Operation(summary = "Insere novo item de pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item de pedido inserido com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ItemPedido.class))),
            @ApiResponse(responseCode = "400", description = "Erro de validação",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    @Schema(description = "Método para inserir novos itens de pedido", example = "Inserir item de pedido com quantidade 5 e valor 100.0")
    public ResponseEntity<?> inserirItemPedido(@Valid @RequestBody ItemPedido itemPedido, BindingResult erros) {
        if (erros.hasErrors()) {
            Map<String, String> errosTotais = new HashMap<>();
            for (FieldError erro : erros.getFieldErrors()) {
                errosTotais.put(erro.getField(), erro.getDefaultMessage());
            }
            return new ResponseEntity<>(errosTotais, HttpStatus.BAD_REQUEST);
        }
        itemService.inserirItemPedido(itemPedido);
        return new ResponseEntity<>("Item de pedido inserido com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{ids}")
    @Schema(description = "Método que exclui itens de pedido", example = "Excluir itens de pedido com IDs 1 e 2")
    @Operation(summary = "Deleta um ou mais itens de pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item(ns) de pedido deletado(s) com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ItemPedido.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<String> excluirItemPedido(@PathVariable("ids") int[] ids) {
        return itemService.deletarItensPedido(ids);
    }

    @PutMapping("/atualizar/{id}")
    @Schema(description = "Atualiza item de pedido", example = "Atualizar item de pedido com ID 1")
    @Operation(summary = "Atualiza um item de pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item de pedido atualizado com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ItemPedido.class))),
            @ApiResponse(responseCode = "404", description = "Item de pedido não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<String> atualizarItemPedido(@PathVariable int id, @Valid @RequestBody ItemPedido itemPedidoAtualizado, BindingResult resultado) {
        return itemService.atualizarItemPedido(id, itemPedidoAtualizado);
    }
}

package com.example.apibimo.controllers;

import com.example.apibimo.models.Pedido;
import com.example.apibimo.services.PedidoService;
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
@RequestMapping("/apibimo/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/selecionarTodos")
    @Operation(summary = "Busca todos os pedidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pedidos retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public List<Pedido> listarPedidos() {
        return pedidoService.buscarTodosPedidos();
    }

    @GetMapping("/selecionarPorID/{id}")
    @Operation(summary = "Busca pedido por ID", description = "Busca pedido com base no ID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido retornado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content)
    })
    public Pedido buscarPedidoPorID(@PathVariable int id) {
        return pedidoService.buscarPedidoPorID(id);
    }

    @PostMapping("/inserir")
    @Operation(summary = "Insere um novo pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido inserido com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "400", description = "Erro na validação dos dados", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> inserirPedido(@Valid @RequestBody Pedido pedido, BindingResult erros) {
        if (erros.hasErrors()) {
            Map<String, String> errosTotais = new HashMap<>();
            for (FieldError erro : erros.getFieldErrors()) {
                errosTotais.put(erro.getField(), erro.getDefaultMessage());
            }
            return new ResponseEntity<>(errosTotais, HttpStatus.BAD_REQUEST);
        }
        return pedidoService.inserirPedido(pedido);
    }

    @DeleteMapping("/deletar/{ids}")
    @Operation(summary = "Deleta um ou mais pedidos", description = "Exclui um ou mais pedidos com base nos IDs fornecidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido(s) deletado(s) com sucesso!",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<String> excluirPedido(@PathVariable("ids") int[] ids) {
        return pedidoService.deletarPedidos(ids);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza um pedido", description = "Atualiza os dados de um pedido existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<String> atualizarPedido(@PathVariable int id, @Valid @RequestBody Pedido pedidoAtualizado, BindingResult resultado) {
        return pedidoService.atualizarPedido(id, pedidoAtualizado);
    }
}

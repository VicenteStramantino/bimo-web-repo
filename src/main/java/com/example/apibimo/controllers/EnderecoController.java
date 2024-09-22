package com.example.apibimo.controllers;

import com.example.apibimo.models.Endereco;
import com.example.apibimo.services.EnderecoService;
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
@RequestMapping("/apibimo/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/selecionarTodos")
    @Operation(summary = "Procura todos os endereços")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de endereços retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Endereco.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public List<Endereco> listarEnderecos() {
        return enderecoService.buscarTodosEnderecos();
    }

    @GetMapping("/selecionarPorID/{id}")
    @Operation(summary = "Busca endereço por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço retornado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Endereco.class))),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public Endereco buscarEnderecoPorID(@PathVariable int id) {
        return enderecoService.buscarEnderecoPorID(id);
    }

    @PostMapping("/inserir")
    @Operation(summary = "Insere novo endereço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço inserido com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Endereco.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> inserirEndereco(@Valid @RequestBody Endereco endereco, BindingResult erros) {
        if (erros.hasErrors()) {
            Map<String, String> errosTotais = new HashMap<>();
            for (FieldError erro : erros.getFieldErrors()) {
                errosTotais.put(erro.getField(), erro.getDefaultMessage());
            }
            return new ResponseEntity<>(errosTotais, HttpStatus.BAD_REQUEST);
        }
        enderecoService.inserirEndereco(endereco);
        return new ResponseEntity<>("Endereço inserido com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{ids}")
    @Operation(summary = "Deleta endereços por IDs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço(s) deletado(s) com sucesso!",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<String> excluirEnderecos(@PathVariable int[] ids) {
        return enderecoService.deletarEnderecos(ids);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza um endereço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Endereco.class))),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<String> atualizarEndereco(@PathVariable int id, @Valid @RequestBody Endereco enderecoAtualizado, BindingResult resultado) {
        try {
            return enderecoService.atualizarEndereco(id, enderecoAtualizado);
        }catch (Exception npc){
            return ResponseEntity.ok(npc.getMessage());
        }
    }
}

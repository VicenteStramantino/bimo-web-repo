package com.example.apibimo.controllers;

import com.example.apibimo.models.Usuario;
import com.example.apibimo.services.UsuarioService;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apibimo/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/selecionarTodos")
    @Operation(summary = "Procura todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public List<Usuario> listarUsuarios() {
        return usuarioService.buscarTodosUsuarios();
    }

    @GetMapping("/selecionarPorID/{id}")
    @Schema(description = "Busca usuário por ID", example = "Buscar usuário com ID 1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public Usuario buscarUsuarioPorID(@PathVariable int id) {
        return usuarioService.buscarUsuarioPorID(id);
    }


    @GetMapping("/selecionarPorTelefone/{telefone}")
    @Schema(description = "Busca usuario por telefone, para facilitar funcionamento do mobile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public Usuario buscarPorTelefone(@PathVariable String telefone){
        return usuarioService.findUsuarioByTelefone(telefone);
    }


    @GetMapping("/selecionarPorHash/{hash}")
    @Schema(description = "Busca usuario por hash, para facilitar funcionamento do mobile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public Usuario buscarUsuarioPorHash(@PathVariable String hash){
        return usuarioService.findUsuarioByCidhash(hash);
    }


    @GetMapping("/selecionarPorEmail/{cemail}")
    @Schema(description = "Busca usuario por hash, para facilitar funcionamento do mobile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public Usuario buscarPorEmail(@PathVariable String cemail){
        return usuarioService.buscarUsuarioPorEmail(cemail);
    }


    @PostMapping("/inserir")
    @Operation(summary = "Insere novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário inserido com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    @Schema(description = "Método para inserir novos usuários", example = "Inserir usuário com nome 'João'")
    public ResponseEntity<?> inserirUsuario(@Valid @RequestBody Usuario usuario, BindingResult erros) {
        if (erros.hasErrors()) {
            Map<String, String> errosTotais = new HashMap<>();
            for (FieldError erro : erros.getFieldErrors()) {
                errosTotais.put(erro.getField(), erro.getDefaultMessage());
            }
            return new ResponseEntity<>(errosTotais, HttpStatus.BAD_REQUEST);
        }
        usuarioService.inserirUsuario(usuario);
        return new ResponseEntity<>("Usuário inserido com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{ids}")
    @Schema(description = "Método que exclui usuários", example = "Excluir usuários com IDs 1 e 2")
    @Operation(summary = "deleta um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<String> excluirUsuario(@PathVariable("ids") int[] ids) {
        return usuarioService.deletarUsuarios(ids);
    }

    @PutMapping("/atualizar/{id}")
    @Schema(description = "Atualiza usuário", example = "Atualizar usuário com ID 1")
    @Operation(summary = "Atualiza um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<String> atualizarUsuario(@PathVariable int id, @Validated @RequestBody Usuario usuarioAtualizado, BindingResult resultado) {
        return usuarioService.atualizarUsuario(id, usuarioAtualizado);
    }
}

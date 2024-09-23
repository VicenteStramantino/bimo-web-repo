package com.example.apibimo.services;

import com.example.apibimo.models.Usuario;
import com.example.apibimo.repository.UsuarioRepository;
import com.example.apibimo.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para buscar todos os usuários
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Método para buscar usuário por ID
    public Usuario buscarUsuarioPorID(int id) {
        return usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado"));
    }

    // Método para inserir novo usuário
    public ResponseEntity<String> inserirUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário inserido com sucesso");
    }

    // Método para deletar usuários por ID (array de IDs)
    public ResponseEntity<String> deletarUsuarios(@PathVariable int[] ids) {
        for (int id : ids) {
            usuarioRepository.deleteById(id);
        }
        return ResponseEntity.ok("Usuário(s) deletado(s) com sucesso");
    }

    // Método para atualizar um usuário
    public ResponseEntity<String> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setCnome(usuarioAtualizado.getCnome());
            usuario.setCsobrenome(usuarioAtualizado.getCsobrenome());
            usuario.setCcpf(usuarioAtualizado.getCcpf());
            usuario.setCemail(usuarioAtualizado.getCemail());
            usuario.setCcnpj(usuarioAtualizado.getCcnpj());
            usuario.setCtelefone(usuarioAtualizado.getCtelefone());
            usuario.setDdatanascimento(usuarioAtualizado.getDdatanascimento());
            usuario.setClinklinkedin(usuarioAtualizado.getClinklinkedin());
            usuario.setCidhash(usuarioAtualizado.getCidhash());
            usuario.setCespecialidadeprofissional(usuarioAtualizado.getCespecialidadeprofissional());
            usuario.setTransaction_made(usuarioAtualizado.isTransaction_made());
            usuarioRepository.save(usuario);
            return ResponseEntity.ok("Usuário atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.apibimo.services;

import com.example.apibimo.models.Endereco;
import com.example.apibimo.repository.EnderecoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    // Método para buscar todos os endereços
    public List<Endereco> buscarTodosEnderecos() {
        return enderecoRepository.findAll();
    }

    // Método para buscar endereço por ID
    public Endereco buscarEnderecoPorID(int id) {
        return enderecoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Endereço não encontrado"));
    }

    // Método para inserir novo endereço
    public ResponseEntity<String> inserirEndereco(@RequestBody Endereco endereco) {
        enderecoRepository.save(endereco);
        return ResponseEntity.ok("Endereço inserido com sucesso");
    }

    // Método para deletar endereços por ID (array de IDs)
    public ResponseEntity<String> deletarEnderecos(@PathVariable int[] ids) {
        for (int id : ids) {
            enderecoRepository.deleteById(id);
        }
        return ResponseEntity.ok("Endereço(s) deletado(s) com sucesso");
    }

    // Método para atualizar um endereço
    public ResponseEntity<String> atualizarEndereco(@PathVariable Integer id, @RequestBody Endereco enderecoAtualizado) {
        Optional<Endereco> enderecoExistente = enderecoRepository.findById(id);
        if (enderecoExistente.isPresent()) {
            Endereco endereco = enderecoExistente.get();
            endereco.setcCep(enderecoAtualizado.getcCep());
            endereco.setcBairro(enderecoAtualizado.getcBairro());
            endereco.setiNumero(enderecoAtualizado.getiNumero());
            endereco.setcRua(enderecoAtualizado.getcRua());
            endereco.setcEstado(enderecoAtualizado.getcEstado());
            enderecoRepository.save(endereco);
            return ResponseEntity.ok("Endereço atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

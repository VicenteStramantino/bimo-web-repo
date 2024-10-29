package com.example.apibimo.services;

import com.example.apibimo.models.Categoria;
import com.example.apibimo.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Método para buscar todas as categorias
    public List<Categoria> buscarTodasCategorias() {
        return categoriaRepository.findAll();
    }

    // Método para buscar categoria por ID
    public Categoria buscarCategoriaPorID(int id) {
        return categoriaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Categoria não encontrada"));
    }

    // Método para inserir nova categoria
    public ResponseEntity<String> inserirCategoria(@RequestBody Categoria categoria) {
        categoriaRepository.save(categoria);
        return ResponseEntity.ok("Categoria inserida com sucesso");
    }

    // Método para deletar categorias por ID (array de IDs)
    public ResponseEntity<String> deletarCategorias(@PathVariable int[] ids) {
        for (int id : ids) {
            categoriaRepository.deleteById(id);
        }
        return ResponseEntity.ok("Categoria(s) deletada(s) com sucesso");
    }

    // Método para atualizar uma categoria
    public ResponseEntity<String> atualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoriaAtualizada) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);
        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            categoria.setcNome(categoriaAtualizada.getcNome());
            categoria.setcTipo(categoriaAtualizada.getcTipo());
            categoriaRepository.save(categoria);
            return ResponseEntity.ok("Categoria atualizada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

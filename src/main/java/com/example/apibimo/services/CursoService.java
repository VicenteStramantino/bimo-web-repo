package com.example.apibimo.services;

import com.example.apibimo.models.Curso;
import com.example.apibimo.repository.CursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Método para buscar todos os cursos
    public List<Curso> buscarTodosCursos() {
        return cursoRepository.findAll();
    }

    // Método para buscar curso por ID
    public Curso buscarCursoPorID(int id) {
        return cursoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Curso não encontrado"));
    }

    // Método para inserir novo curso
    public ResponseEntity<String> inserirCurso(@RequestBody Curso curso) {
        cursoRepository.save(curso);
        return ResponseEntity.ok("Curso inserido com sucesso");
    }

    // Método para deletar cursos por ID (array de IDs)
    public ResponseEntity<String> deletarCursos(@PathVariable int[] ids) {
        for (int id : ids) {
            cursoRepository.deleteById(id);
        }
        return ResponseEntity.ok("Curso(s) deletado(s) com sucesso");
    }

    // Método para atualizar um curso
    public ResponseEntity<String> atualizarCurso(@PathVariable Integer id, @RequestBody Curso cursoAtualizado) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);
        if (cursoExistente.isPresent()) {
            Curso curso = cursoExistente.get();
            curso.setcNome(cursoAtualizado.getcNome());
            curso.setcDescricao(cursoAtualizado.getcDescricao());
            curso.setfValor(cursoAtualizado.getfValor());
            curso.setcCertificacao(cursoAtualizado.getcCertificacao());
            curso.setcCategoria(cursoAtualizado.getcCategoria());
            curso.setiNumeroInscricao(cursoAtualizado.getiNumeroInscricao());
            curso.setcDuracao(cursoAtualizado.getcDuracao());
            cursoRepository.save(curso);
            return ResponseEntity.ok("Curso atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

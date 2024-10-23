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

    public List<Curso> buscarTodosCursos() {
        return cursoRepository.findAll();
    }

    public Curso buscarCursoPorID(int id) {
        return cursoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Curso não encontrado"));
    }


}

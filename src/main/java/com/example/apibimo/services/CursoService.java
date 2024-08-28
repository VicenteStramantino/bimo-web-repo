package com.example.apibimo.services;

import com.example.apibimo.repository.CursoRepository;
import com.example.apibimo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }
}

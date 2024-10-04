package com.example.apibimo.services;

import com.example.apibimo.models.Plano;
import com.example.apibimo.repository.PlanoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {

    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public List<Plano> buscarTodosPlanos() {
        return planoRepository.findAll();
    }

    public Plano buscarPlanoPorID(int id) {
        return planoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Plano não encontrado"));
    }

}

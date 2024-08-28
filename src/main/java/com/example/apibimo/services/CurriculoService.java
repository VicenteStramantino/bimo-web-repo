package com.example.apibimo.services;

import com.example.apibimo.models.Curriculo;
import com.example.apibimo.repository.CurriculoRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculoService {

    private final CurriculoRepository curriculoRepository;

    public CurriculoService(CurriculoRepository curriculoRepository){
        this.curriculoRepository = curriculoRepository;
    }

    public List<Curriculo> buscarTodos(){
        return curriculoRepository.findAll();
    }

    public Optional<Curriculo> buscarPorID(int id){
        return curriculoRepository.findById(id);
    }
    public ResponseEntity<String> inserir(@RequestBody Curriculo curriculo){
        try {
            if(curriculo == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curriculo nao pode ser nulo");
            }
            else {
                if (curriculoRepository.existsById(curriculo.getsId())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Curriculo já existe");
                }
                curriculoRepository.save(curriculo);
                return ResponseEntity.ok("Curriculo inserido com sucesso");
            }
        }
        catch (DataAccessException DAE){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao se conectar com o banco de dados");
        }
    }

    public ResponseEntity<String> deletar(int id){
        Optional<Curriculo> curriculoOptional = curriculoRepository.findById(id);
        if(curriculoOptional.isPresent()){
            curriculoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Curriculo excluido");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curriculo inexistente");
        }
    }
}

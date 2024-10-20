package com.example.apibimo.repository;
import com.example.apibimo.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    Optional<Endereco> findByIdUsuario(Integer integer);
}

package com.example.apibimo.repository;

import com.example.apibimo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByCidhash(String cidhash);

    Usuario findByCtelefone(String cTelefone);

    Usuario findUsuarioByCemail(String cemail);

}

package com.example.agenda.repository;

import com.example.agenda.models.Registro;
import com.example.agenda.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ResgistroRepository extends JpaRepository<Registro, UUID> {
    List<Registro> findByUsuario(Usuario usuario);
}

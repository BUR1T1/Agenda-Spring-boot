package com.example.agenda.repository;

import com.example.agenda.models.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface AcessoRepository extends JpaRepository<Acesso, UUID> {

    Optional<Object> findByUserName(String username);
}

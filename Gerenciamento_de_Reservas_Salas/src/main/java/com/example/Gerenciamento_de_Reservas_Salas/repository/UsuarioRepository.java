package com.example.Gerenciamento_de_Reservas_Salas.repository;

import com.example.Gerenciamento_de_Reservas_Salas.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}

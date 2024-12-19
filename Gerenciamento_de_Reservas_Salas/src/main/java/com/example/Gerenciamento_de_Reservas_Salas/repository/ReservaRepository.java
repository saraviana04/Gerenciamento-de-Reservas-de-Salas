package com.example.Gerenciamento_de_Reservas_Salas.repository;

import com.example.Gerenciamento_de_Reservas_Salas.model.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}

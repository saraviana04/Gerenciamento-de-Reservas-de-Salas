package com.example.Gerenciamento_de_Reservas_Salas.repository;

import com.example.reserva_salas.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}

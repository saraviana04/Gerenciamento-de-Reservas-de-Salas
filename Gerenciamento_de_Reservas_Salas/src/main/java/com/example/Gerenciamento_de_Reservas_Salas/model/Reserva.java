package com.example.reserva_salas.model;

import com.example.Gerenciamento_de_Reservas_Salas.model.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private com.example.reserva_salas.model.Sala sala;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDateTime dataReserva;

    @Column(nullable = false)
    private Integer duracaoHoras;

    @Column(nullable = false)
    private String status; // PENDENTE, APROVADA, REJEITADA
}

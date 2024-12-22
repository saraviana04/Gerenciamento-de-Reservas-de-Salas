
package com.example.Gerenciamento_de_Reservas_Salas.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.Valid;



import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;
import org.antlr.v4.runtime.misc.NotNull;

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
    @NotNull(message = "A sala é obrigatória.")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @NotNull(message = "O usuário é obrigatório.")
    private Usuario usuario;

    @Column(nullable = false)
    @NotNull(message = "A data da reserva é obrigatória.")
    @Future(message = "A data da reserva deve ser no futuro.")
    private LocalDateTime dataReserva;

    @Column(nullable = false)
    @NotNull(message = "A duração é obrigatória.")
    @Min(value = 1, message = "A duração deve ser de pelo menos 1 hora.")
    @Max(value = 8, message = "A duração não pode exceder 8 horas.")
    private Integer duracaoHoras;

    @Column(nullable = false)
    @NotBlank(message = "O status é obrigatório.")
    @Pattern(regexp = "PENDENTE|APROVADA|REJEITADA", message = "O status deve ser PENDENTE, APROVADA ou REJEITADA.")
    private String status; // PENDENTE, APROVADA, REJEITADA
}

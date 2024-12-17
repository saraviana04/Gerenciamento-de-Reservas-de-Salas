package com.example.reserva_salas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "salas")
@Data
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer capacidade;

    @Column
    private String descricao;
}

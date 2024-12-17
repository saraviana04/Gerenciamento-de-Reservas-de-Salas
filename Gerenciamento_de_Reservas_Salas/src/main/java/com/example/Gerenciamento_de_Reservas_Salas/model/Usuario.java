package com.example.Gerenciamento_de_Reservas_Salas.model;
import  jakarta.persistence.*;
import lombok.*;




@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String role; // ADMIN ou USER
}

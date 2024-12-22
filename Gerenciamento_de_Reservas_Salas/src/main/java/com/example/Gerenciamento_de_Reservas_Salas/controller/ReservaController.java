package com.example.Gerenciamento_de_Reservas_Salas.controller;

import com.example.Gerenciamento_de_Reservas_Salas.model.Reserva;
import com.example.Gerenciamento_de_Reservas_Salas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    // Criar uma nova reserva
    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaRepository.save(reserva));
    }

    // Listar todas as reservas
    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas() {
        return ResponseEntity.ok(reservaRepository.findAll());
    }

    // Obter detalhes de uma reserva específica
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obterReserva(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        return reserva.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar uma reserva
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizarReserva(@PathVariable Long id, @Valid @RequestBody Reserva novaReserva) {
        return reservaRepository.findById(id)
                .map(reserva -> {
                    reserva.setSala(novaReserva.getSala());
                    reserva.setUsuario(novaReserva.getUsuario());
                    reserva.setDataReserva(novaReserva.getDataReserva());
                    reserva.setDuracaoHoras(novaReserva.getDuracaoHoras());
                    reserva.setStatus(novaReserva.getStatus());
                    return ResponseEntity.ok(reservaRepository.save(reserva));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Excluir uma reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirReserva(@PathVariable Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

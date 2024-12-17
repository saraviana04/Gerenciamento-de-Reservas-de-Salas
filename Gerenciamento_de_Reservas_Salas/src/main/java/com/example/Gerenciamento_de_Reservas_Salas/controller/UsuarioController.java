package com.example.Gerenciamento_de_Reservas_Salas.controller;
import com.example.Gerenciamento_de_Reservas_Salas.model.Usuario;
import com.example.Gerenciamento_de_Reservas_Salas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
}

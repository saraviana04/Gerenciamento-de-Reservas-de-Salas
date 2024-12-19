package com.example.Gerenciamento_de_Reservas_Salas.controller;

import com.example.Gerenciamento_de_Reservas_Salas.model.Usuario;
import com.example.Gerenciamento_de_Reservas_Salas.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testCriarUsuario() throws Exception {
        // Configura um mock de usuário
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setEmail("teste@example.com");
        usuario.setSenha("1234");
        usuario.setRole("USER");

        // Configura o mock para o método save
        when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);

        // Faz a requisição POST para criar um usuário
        mockMvc.perform(post("/api/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "email": "teste@example.com",
                                    "senha": "1234",
                                    "role": "USER"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.email").value("teste@example.com"))
                .andExpect(jsonPath("$.role").value("USER"));

        // Verifica se o método save foi chamado corretamente
        verify(usuarioRepository, times(1)).save(Mockito.any(Usuario.class));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testListarUsuarios() throws Exception {
        // Configura um mock de lista de usuários
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setEmail("teste@example.com");
        usuario.setSenha("1234");
        usuario.setRole("USER");

        when(usuarioRepository.findAll()).thenReturn(Collections.singletonList(usuario));

        // Faz a requisição GET para listar usuários
        mockMvc.perform(get("/api/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].email").value("teste@example.com"))
                .andExpect(jsonPath("$[0].role").value("USER"));

        // Verifica se o método findAll foi chamado corretamente
        verify(usuarioRepository, times(1)).findAll();
    }
}
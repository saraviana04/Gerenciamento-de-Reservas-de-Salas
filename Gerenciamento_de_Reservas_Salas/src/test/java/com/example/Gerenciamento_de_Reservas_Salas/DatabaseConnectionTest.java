package com.example.Gerenciamento_de_Reservas_Salas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testDatabaseConnection() {
        try {
            // Verifica se a conexão está funcionando com uma consulta simples
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            assertTrue(result != null && result == 1, "A consulta não retornou o valor esperado.");
            System.out.println("Conexão com o banco de dados bem-sucedida!");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false, "Falha ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}

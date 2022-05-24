package com.clean.architecture.application.usuario.recuperar

import com.clean.architecture.domain.usuario.Usuario
import com.clean.architecture.domain.usuario.UsuarioRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class RecuperarUsuarioTest {


    // 1. Recuperar usuario valido
    @Test
    @DisplayName("""
        Dado parametros válidos para recuperar um usuário
        Quando caso de uso for executado
        Então um usário será recuperado.
    """)
    fun recuperarUsuario() {
        // setup:
        val matricula = "12345"
        val nome = "Marta"
        val inputCommand = RecuperarUsuarioCommand(matricula, nome)
        val repository = mock(UsuarioRepository::class.java)
        `when`(repository.obterUsuario(anyString(), anyString())).thenReturn(Usuario.newUsuario(nome, "dummyEmail", "dummyEndereco", "dummyTelefone"))
        // execute:
        val output = RecuperarUsuario(repository).execute(inputCommand)
        // verify:
        assertThat(output.nome).isEqualTo(nome)
        assertThat(output.matricula).isNotNull()
        assertThat(output.email).isNotNull()
        assertThat(output.id).isNotNull()
    }
}

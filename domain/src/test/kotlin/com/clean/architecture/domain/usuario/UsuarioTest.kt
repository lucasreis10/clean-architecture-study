package com.clean.architecture.domain.usuario

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UsuarioTest {


    @Test
    fun criarUsuarioValido() {
        // setup:
        // execute:
        val nome = "Marta"
        val novoUsuario = UsuarioTestHelper.usuario(nome = nome)
        // verify
        assertThat(novoUsuario.nome).isEqualTo(nome)
        assertThat(novoUsuario.id).isNotNull()
        assertThat(novoUsuario.matricula).isNotNull()
        assertThat(novoUsuario.ativo).isTrue()
        assertThat(novoUsuario.dataCriacao).isNotNull()
        assertThat(novoUsuario.dataInativacao).isNull()
    }


}

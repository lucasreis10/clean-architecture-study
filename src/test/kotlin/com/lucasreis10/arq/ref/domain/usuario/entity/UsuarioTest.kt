package com.lucasreis10.arq.ref.domain.usuario.entity

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UsuarioTest {


    @Test
    fun criarUsuario() {
        // setup:
        val matricula = "12345"
        val novoUsuario = UsuarioTestHelper.usuario(matricula = matricula)
        // execute:
        // verify
        assertThat(novoUsuario.matricula).isEqualTo(matricula)
    }


}

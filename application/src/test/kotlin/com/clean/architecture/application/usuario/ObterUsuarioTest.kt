package com.clean.architecture.application.usuario

import com.clean.architecture.application.usuario.obter.InputObterUsuarioDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObterUsuarioTest {


    @Test
    fun obterUsuario() {
        // setup:
        val usuarioRepositoryMock = UsuarioRepositoryMock()
        val input = InputObterUsuarioDto("dummy", "dummy")
        // execute:
        val outputUsuario = ObterUsuario(usuarioRepositoryMock).execute(input)
        // verify
        assertThat(outputUsuario?.matricula).isEqualTo("12345")
    }

}

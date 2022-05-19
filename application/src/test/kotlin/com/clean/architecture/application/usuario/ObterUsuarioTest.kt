package com.clean.architecture.application.usuario

import com.clean.architecture.application.usuario.recuperar.InputObterUsuarioDto
import com.clean.architecture.application.usuario.recuperar.RecuperarUsuario
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObterUsuarioTest {


    @Test
    fun obterUsuario() {
        // setup:
        val usuarioRepositoryMock = UsuarioRepositoryMock()
        val input = InputObterUsuarioDto("dummy", "dummy")
        // execute:
        val outputUsuario = RecuperarUsuario(usuarioRepositoryMock).execute(input)
        // verify
        assertThat(outputUsuario?.matricula).isNotNull()
    }

}

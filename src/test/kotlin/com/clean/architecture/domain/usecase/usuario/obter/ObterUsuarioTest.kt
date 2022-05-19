package com.clean.architecture.domain.usecase.usuario.obter

import com.lucasreis10.arq.ref.usecase.usuario.UsuarioRepositoryMock
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class ObterUsuarioTest {

    private val usuarioRepositoryMock = UsuarioRepositoryMock()

    @Test
    fun obterUsuario() {
        // setup:
        val input = InputObterUsuarioDto("dummy", "dummy")
        // execute:
        val outputUsuario = ObterUsuario(usuarioRepositoryMock).execute(input)
        // verify
        assertThat(outputUsuario?.matricula).isEqualTo("12345")
    }

}

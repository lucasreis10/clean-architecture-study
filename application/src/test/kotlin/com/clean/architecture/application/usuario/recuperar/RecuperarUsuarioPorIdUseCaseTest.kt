package com.clean.architecture.application.usuario.recuperar

import MockitoHelper
import MockitoHelper.anyObject
import com.clean.architecture.application.usuario.UsuarioTestHelper
import com.clean.architecture.domain.usuario.UsuarioGateway
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class RecuperarUsuarioPorIdUseCaseTest {

    @Mock
    lateinit var usuarioGateway: UsuarioGateway
    @InjectMocks
    lateinit var recuperarUsuarioPorIdUseCase: DefaultRecuperarUsuarioPorIdUseCase


    @Test
    @DisplayName("""
        Dado parametro ID de usuário válido
        Quando recuperarUsuarioPorId for executado
        Então um usuário com ID é retornado.
    """)
    fun recuperarUsuarioExistente() {
        // setup:
        val usuarioId = "2340932"
        val usuarioMock = UsuarioTestHelper.usuario()
        val command = RecuperarUsuarioPorIdCommand(usuarioId)
        `when`(usuarioGateway.obterUsuario(anyString())).thenReturn(usuarioMock)
        // execute:
        val output = recuperarUsuarioPorIdUseCase.execute(command)
        // verify:
        assertThat(output!!.id).isNotNull()
        assertThat(output.nome).isNotNull()
        assertThat(output.matricula).isNotNull()
    }

}

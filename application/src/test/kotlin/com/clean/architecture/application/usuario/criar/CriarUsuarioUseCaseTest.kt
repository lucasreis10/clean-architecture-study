package com.clean.architecture.application.usuario.criar

import com.clean.architecture.application.usuario.UsuarioTestHelper.Companion.criarUsuarioCommand
import com.clean.architecture.application.usuario.UsuarioTestHelper.Companion.usuario
import com.clean.architecture.domain.usuario.UsuarioGateway
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.any
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CriarUsuarioUseCaseTest {

    @Mock
    lateinit var usuarioGateway: UsuarioGateway
    @InjectMocks
    lateinit var criarUsuarioUseCase: DefaultCriarUsuarioUseCase


    @Test
    @DisplayName("""
        Dado parametros válidos para criar um usuário
        Quando o criar usário é chamado
        Então um usuário com ID deve ser retornado.
    """)
    fun criarUsuario_valido() {
        // setup:
        val nome = "Mike"
        val criarUsuarioCommand = criarUsuarioCommand(nome)
        val usuarioMock = usuario(nome)
        `when`(usuarioGateway.criarUsuario(any())).thenReturn(usuarioMock)
        // execute:
        val output: CriarUsuarioOutput = criarUsuarioUseCase.execute(criarUsuarioCommand)
        // verify:
        assertThat(output.id).isNotNull()
        assertThat(output.matricula).isNotNull()
        assertThat(output.dataCriacao).isNotNull()
        assertThat(output.nome).isEqualTo(nome)
    }

}

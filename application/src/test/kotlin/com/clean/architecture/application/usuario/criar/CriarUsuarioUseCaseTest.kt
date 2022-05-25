package com.clean.architecture.application.usuario.criar

import MockitoHelper
import com.clean.architecture.application.usuario.UsuarioTestHelper.Companion.criarUsuarioCommand
import com.clean.architecture.application.usuario.UsuarioTestHelper.Companion.usuario
import com.clean.architecture.domain.excepetion.DominioException
import com.clean.architecture.domain.usuario.UsuarioGateway
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
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
    fun criarUsuarioValido() {
        // setup:
        val nome = "Mike"
        val criarUsuarioCommand = criarUsuarioCommand(nome)
        val usuarioMock = usuario(nome)
        `when`(usuarioGateway.criarUsuario(MockitoHelper.anyObject())).thenReturn(usuarioMock)
        // execute:
        val output: CriarUsuarioOutput = criarUsuarioUseCase.execute(criarUsuarioCommand)
        // verify:
        assertThat(output.id).isNotNull()
        assertThat(output.matricula).isNotNull()
        assertThat(output.dataCriacao).isNotNull()
        assertThat(output.nome).isEqualTo(nome)
    }

    @Test
    @DisplayName("""
        Dado parametro 'nome' inválido menor que 3 caracters
        Quando o criar usário é chamado
        Então um erro é lançado.
    """)
    fun criarUsuarioInvalido_nomeMenorQueOPermitido() {
        // setup:
        val nome = "Aa"
        val criarUsuarioCommand = criarUsuarioCommand(nome)
        // execute:
        val output =  catchThrowable { criarUsuarioUseCase.execute(criarUsuarioCommand) }
        // verify:
        assertThat(output)
            .isInstanceOf(DominioException::class.java)
            .hasMessageContaining("Nome do usuário deve conter mais de 3 caracters")
    }

}

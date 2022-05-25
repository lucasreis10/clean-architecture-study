package com.clean.architecture.application.usuario.recuperar

import com.clean.architecture.domain.usuario.Usuario
import com.clean.architecture.domain.usuario.UsuarioGateway
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class RecuperarUsuarioUseCaseTest {

    @Mock
    lateinit var usuarioGateway: UsuarioGateway
    @InjectMocks
    lateinit var recuperarUsuarioUseCase: DefaultRecuperarUsuario


    @Test
    @DisplayName("""
        Dado parametros válidos para recuperar um usuário
        Quando recuperada usuario é chamdo
        Então um usário será recuperado.
    """)
    fun recuperarUsuario() {
        // setup:
        val matricula = "12345"
        val nome = "Marta"
        val inputCommand = RecuperarUsuarioCommand(matricula, nome)
        `when`(usuarioGateway.obterUsuario(anyString(), anyString())).thenReturn(Usuario.newUsuario(nome, "dummyEmail", "dummyEndereco", "dummyTelefone"))
        // execute:
        val output = recuperarUsuarioUseCase.execute(inputCommand)
        // verify:
        assertThat(output!!.nome).isEqualTo(nome)
        assertThat(output.matricula).isNotNull()
        assertThat(output.email).isNotNull()
        assertThat(output.id).isNotNull()
    }


    @Test
    @DisplayName("""
        Dado parametros que não correspondem a nenhum usuário
        Quando recuperada usuario é chamdo
        Então nenhum usário será recuperado.
    """)
    fun recuperarUsuario_comParametrosInexistentesParaUsuario() {
        // setup:
        val matricula = "0000"
        val nome = "Dummy"
        val inputCommand = RecuperarUsuarioCommand(matricula, nome)
        `when`(usuarioGateway.obterUsuario(anyString(), anyString())).thenReturn(null)
        // execute:
        val output = recuperarUsuarioUseCase.execute(inputCommand)
        // verify:
        assertThat(output).isNull()
    }
}

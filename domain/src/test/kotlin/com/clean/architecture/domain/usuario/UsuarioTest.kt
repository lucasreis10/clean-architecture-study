package com.clean.architecture.domain.usuario

import com.clean.architecture.domain.excepetion.DominioException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UsuarioTest {


    @Test
    @DisplayName("""
        Dado parametros válidos para criar um usuário
        Quando o criar usário é chamado
        Então um usuário com ID deve ser retornado.
    """)
    fun criarUsuarioValido() {
        // setup:
        val nome = "Marta"
        // execute:
        val novoUsuario = Usuario.newUsuario(nome, "dummyEmail", "dummyEndereco", "dummyTelefone")
        // verify
        assertThat(novoUsuario.nome).isEqualTo(nome)
        assertThat(novoUsuario.id).isNotNull()
        assertThat(novoUsuario.matricula).isNotNull()
        assertThat(novoUsuario.ativo).isTrue()
        assertThat(novoUsuario.dataCriacao).isNotNull()
        assertThat(novoUsuario.dataInativacao).isNull()
    }

    @Test
    @DisplayName("""
        Dado que um usuário inválido é criado com 'nome' menor que 3 caracters 
        Quando o criar usário é chamado
        Então uma exceção deve ser lançada 
        """)
    fun criarUsuarioInvalido_nomeMenorQueOPermitido() {
        // setup:
        val nome = "Gi"
        // execute:
        val execption =  catchThrowable { UsuarioTestHelper.usuario(nome = nome) }
        // verify
        assertThat(execption)
            .isInstanceOf(DominioException::class.java)
            .hasMessageContaining("Nome do usuário deve conter mais de 3 caracters")
    }

    @Test
    @DisplayName("""
        Dado que um usuário ativo 
        Quando o inativar usuário é chamado
        Então um usuário inativo é retornado. 
        """)
    fun inativarUsuario() {
        // setup:
        val usuario = UsuarioTestHelper.usuario()
        // execute:
        val usuarioInativo = usuario.inativarUsuario()
        // verify:
        assertThat(usuarioInativo.id).isEqualTo(usuario.id)
        assertThat(usuarioInativo.ativo).isFalse()
        assertThat(usuarioInativo.dataInativacao).isNotNull()
    }


}

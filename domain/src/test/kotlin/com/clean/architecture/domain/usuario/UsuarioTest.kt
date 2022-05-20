package com.clean.architecture.domain.usuario

import com.clean.architecture.domain.excepetion.DominioException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UsuarioTest {


    @Test
    fun criarUsuarioValido() {
        // setup:
        val nome = "Marta"
        // execute:
        val novoUsuario = UsuarioTestHelper.usuario(nome = nome)
        // verify
        assertThat(novoUsuario.nome).isEqualTo(nome)
        assertThat(novoUsuario.id).isNotNull()
        assertThat(novoUsuario.matricula).isNotNull()
        assertThat(novoUsuario.ativo).isTrue()
        assertThat(novoUsuario.dataCriacao).isNotNull()
        assertThat(novoUsuario.dataInativacao).isNull()
    }

    @Test
    @DisplayName("""Dado que um usuário inválido é criado com 'nome' menor que 3 caracters 
        |           Então uma exceção deve ser lançada 
        |           """)
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

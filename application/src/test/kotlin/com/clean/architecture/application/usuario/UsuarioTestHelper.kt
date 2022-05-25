package com.clean.architecture.application.usuario

import com.clean.architecture.application.usuario.criar.CriarUsuarioCommand
import com.clean.architecture.domain.usuario.Usuario

class UsuarioTestHelper {
    companion object {
        fun usuario(nome: String = "dummyNome",
                    email: String = "dummyEmail",
                    endereco: String = "dummyEndereco",
                    telefone: String = "dummyTelefone"
        ): Usuario {
            return Usuario.newUsuario(nome, email, endereco, telefone)
        }

        fun criarUsuarioCommand(
            nome: String = "dummyNome",
            email: String = "dummyEmail",
            endereco: String = "dummyEndereco",
            telefone: String = "dummyTelefone"
        ): CriarUsuarioCommand {
            return CriarUsuarioCommand(nome, email, endereco, telefone)
        }
    }

}

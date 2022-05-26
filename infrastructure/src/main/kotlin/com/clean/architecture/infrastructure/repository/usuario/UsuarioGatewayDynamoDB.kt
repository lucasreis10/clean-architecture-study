package com.clean.architecture.infrastructure.repository.usuario

import com.clean.architecture.domain.usuario.Usuario
import com.clean.architecture.domain.usuario.UsuarioGateway
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UsuarioGatewayDynamoDB: UsuarioGateway {

    override fun criarUsuario(usuario: Usuario): Usuario {
        TODO("Not yet implemented")
    }

    override fun obterUsuario(matricula: String, nome: String): Usuario? {
        TODO("Not yet implemented")
    }
}

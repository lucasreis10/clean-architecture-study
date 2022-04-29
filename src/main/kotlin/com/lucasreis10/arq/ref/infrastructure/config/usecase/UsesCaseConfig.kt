package com.lucasreis10.arq.ref.infrastructure.config.usecase

import com.lucasreis10.arq.ref.infrastructure.usuario.repository.dynamodb.DynamoDbRepositoryUsuario
import com.lucasreis10.arq.ref.usecase.usuario.obter.ObterUsuario
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.Produces


@ApplicationScoped
class UsesCaseConfig(private val usuarioRepository: DynamoDbRepositoryUsuario) {

    @Produces
    fun obterUsuario(): ObterUsuario {
        return ObterUsuario(usuarioRepository)
    }

}

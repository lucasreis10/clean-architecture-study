package com.lucasreis10.arq.ref.infrastructure.config.usecase

import com.lucasreis10.arq.ref.infrastructure.usuario.repository.dynamodb.DynamoDbRepositoryUsuario
import com.lucasreis10.arq.ref.usecase.usuario.obter.ObterUsuario
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.Produces


class UsesCaseConfig() {

    @Inject
    @field: Default
    private lateinit var usuarioRepository: DynamoDbRepositoryUsuario

    @Produces
    @ApplicationScoped
    fun obterUsuario(): ObterUsuario {
        return ObterUsuario(usuarioRepository)
    }

}

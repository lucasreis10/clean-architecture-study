package com.clean.architecture.infrastructure.config.usecase

import com.clean.architecture.application.usuario.ObterUsuario
import com.clean.architecture.infrastructure.repository.dynamodb.usuario.DynamoDbRepositoryUsuario
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.enterprise.inject.Produces
import javax.inject.Inject


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

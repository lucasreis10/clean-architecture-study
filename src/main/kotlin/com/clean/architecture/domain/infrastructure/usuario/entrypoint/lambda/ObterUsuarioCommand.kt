package com.clean.architecture.domain.infrastructure.usuario.entrypoint.lambda

import kotlinx.serialization.Serializable

@Serializable
data class InputObterUsuarioCommand(
    val nome: String,
    val matricula: String,
)

@Serializable
data class OutputObterUsuarioCommand(
    val nome: String,
    val matricula: String,
)


package com.lucasreis10.arq.ref.infrastructure.usuario.entrypoint.lambda

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


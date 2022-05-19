package com.clean.architecture.infrastructure.entrypoint

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


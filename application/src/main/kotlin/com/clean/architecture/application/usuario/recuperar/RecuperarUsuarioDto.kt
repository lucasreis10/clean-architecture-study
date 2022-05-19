package com.clean.architecture.application.usuario.recuperar

data class InputObterUsuarioDto(
    val matricula: String,
    val nome: String
)

data class OutputUsuarioDto(
    val matricula: String,
    val nome: String,
    val email: String,
    val endereco: String,
    val telefone: String,
)

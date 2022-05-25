package com.clean.architecture.application.usuario.criar

data class CriarUsuarioCommand(
    val nome: String,
    val email: String,
    val endereco: String,
    val telefone: String
)

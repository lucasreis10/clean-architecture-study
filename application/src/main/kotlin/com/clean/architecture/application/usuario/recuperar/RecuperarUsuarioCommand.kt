package com.clean.architecture.application.usuario.recuperar

data class RecuperarUsuarioCommand(
    val matricula: String,
    val nome: String
)

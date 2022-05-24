package com.clean.architecture.application.usuario.recuperar

import com.clean.architecture.domain.usuario.Usuario

data class RecueperarUsuarioOutput (
    val id: String,
    val nome: String,
    val matricula: String,
    val email: String,
) {
    companion object {
        fun from(usuarioRecuperado: Usuario): RecueperarUsuarioOutput {
            return RecueperarUsuarioOutput(
                usuarioRecuperado.id.toString(),
                usuarioRecuperado.nome,
                usuarioRecuperado.matricula,
                usuarioRecuperado.email
            )
        }
    }
}

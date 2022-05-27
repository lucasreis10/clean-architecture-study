package com.clean.architecture.application.usuario.recuperar

import com.clean.architecture.domain.usuario.Usuario

data class RecuperarUsuarioPorIdOutput(
    val id: String,
    val nome: String,
    val matricula: String,
) {
    companion object {
        fun from(usuario: Usuario): RecuperarUsuarioPorIdOutput {
            return RecuperarUsuarioPorIdOutput(
                usuario.id.toString(),
                usuario.nome,
                usuario.matricula
            )
        }
    }
}

package com.clean.architecture.application.usuario.criar

import com.clean.architecture.domain.usuario.Usuario
import java.time.Instant

data class CriarUsuarioOutput(
    val id: String,
    val matricula: String,
    val dataCriacao: Instant,
    val nome: String,
) {
    companion object {
        fun from(usuario: Usuario): CriarUsuarioOutput {
            return CriarUsuarioOutput(usuario.id.toString(), usuario.matricula, usuario.dataCriacao, usuario.nome)
        }
    }
}

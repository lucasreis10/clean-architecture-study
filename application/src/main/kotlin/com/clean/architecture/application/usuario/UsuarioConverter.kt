package com.clean.architecture.application.usuario

import com.clean.architecture.application.usuario.recuperar.OutputUsuarioDto
import com.clean.architecture.domain.usuario.Usuario


class UsuarioConverter {

    companion object {
        fun converterParaDto(usuario: Usuario?): OutputUsuarioDto? {
            return if(usuario != null)
            OutputUsuarioDto(usuario.matricula, usuario.nome, usuario.email, usuario.endereco, usuario.telefone)
            else null
        }
    }
}

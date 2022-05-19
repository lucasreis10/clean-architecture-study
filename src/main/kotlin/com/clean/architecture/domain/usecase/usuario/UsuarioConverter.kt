package com.clean.architecture.domain.usecase.usuario

import com.clean.architecture.domain.domain.usuario.entity.Usuario
import com.lucasreis10.arq.ref.usecase.usuario.obter.OutputUsuarioDto

class UsuarioConverter {

    companion object {
        fun converterParaDto(usuario: com.clean.architecture.domain.domain.usuario.entity.Usuario?): OutputUsuarioDto? {
            return if(usuario != null)
            OutputUsuarioDto(usuario.matricula, usuario.nome, usuario.email, usuario.endereco, usuario.telefone)
            else null
        }
    }
}

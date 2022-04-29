package com.lucasreis10.arq.ref.usecase.usuario

import com.lucasreis10.arq.ref.domain.usuario.entity.Usuario
import com.lucasreis10.arq.ref.usecase.usuario.obter.OutputUsuarioDto

class UsuarioConverter {

    companion object {
        fun converterParaDto(usuario: Usuario?): OutputUsuarioDto? {
            return if(usuario != null)
            OutputUsuarioDto(usuario.matricula, usuario.nome, usuario.email, usuario.endereco, usuario.telefone)
            else null
        }
    }
}

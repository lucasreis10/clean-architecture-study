package com.lucasreis10.arq.ref.usecase.usuario.obter

import com.lucasreis10.arq.ref.domain.usuario.UsuarioRepository
import com.lucasreis10.arq.ref.usecase.usuario.UsuarioConverter

class ObterUsuario(private val usuarioRepository: UsuarioRepository) {

    fun execute(input: InputObterUsuarioDto): OutputUsuarioDto? {
        val usuario = usuarioRepository.obterUsuario(input.matricula, input.nome)

        return UsuarioConverter.converterParaDto(usuario)
    }

}

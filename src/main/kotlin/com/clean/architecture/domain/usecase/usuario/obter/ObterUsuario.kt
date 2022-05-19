package com.clean.architecture.domain.usecase.usuario.obter

import com.clean.architecture.domain.domain.usuario.UsuarioRepository
import com.lucasreis10.arq.ref.usecase.usuario.UsuarioConverter

class ObterUsuario(private val usuarioRepository: com.clean.architecture.domain.domain.usuario.UsuarioRepository) {

    fun execute(input: InputObterUsuarioDto): OutputUsuarioDto? {
        val usuario = usuarioRepository.obterUsuario(input.matricula, input.nome)

        return UsuarioConverter.converterParaDto(usuario)
    }

}

package com.clean.architecture.application.usuario.obter

import com.clean.architecture.application.usuario.UsuarioConverter
import com.clean.architecture.application.usuario.UsuarioRepository


class ObterUsuario(private val usuarioRepository: UsuarioRepository) {

    fun execute(input: InputObterUsuarioDto): OutputUsuarioDto? {
        val usuario = usuarioRepository.obterUsuario(input.matricula, input.nome)

        return UsuarioConverter.converterParaDto(usuario)
    }

}

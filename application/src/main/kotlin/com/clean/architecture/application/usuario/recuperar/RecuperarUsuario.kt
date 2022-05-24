package com.clean.architecture.application.usuario.recuperar

import com.clean.architecture.application.usuario.UsuarioConverter
import com.clean.architecture.domain.usuario.UsuarioRepository


class RecuperarUsuario(private val usuarioRepository: UsuarioRepository) {

    fun execute(input: InputObterUsuarioDto): OutputUsuarioDto? {
        val usuario = usuarioRepository.obterUsuario(input.matricula, input.nome)

        return UsuarioConverter.converterParaDto(usuario)
    }

}

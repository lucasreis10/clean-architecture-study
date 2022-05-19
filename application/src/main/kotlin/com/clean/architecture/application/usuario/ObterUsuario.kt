package com.clean.architecture.application.usuario

import com.clean.architecture.application.usuario.obter.InputObterUsuarioDto
import com.clean.architecture.application.usuario.obter.OutputUsuarioDto


class ObterUsuario(private val usuarioRepository: UsuarioRepository) {

    fun execute(input: InputObterUsuarioDto): OutputUsuarioDto? {
        val usuario = usuarioRepository.obterUsuario(input.matricula, input.nome)

        return UsuarioConverter.converterParaDto(usuario)
    }

}

package com.clean.architecture.application.usuario.recuperar

import com.clean.architecture.domain.usuario.UsuarioGateway

class DefaultRecuperarUsuarioPorIdUseCase(val usuarioGateway: UsuarioGateway)
    :RecuperarUsuarioPorIdUseCase() {

    override fun execute(input: RecuperarUsuarioPorIdCommand): RecuperarUsuarioPorIdOutput? {
        val usuarioRecuperado = usuarioGateway.obterUsuario(input.id)

        return if (usuarioRecuperado != null) RecuperarUsuarioPorIdOutput.from(usuarioRecuperado) else null
    }
}

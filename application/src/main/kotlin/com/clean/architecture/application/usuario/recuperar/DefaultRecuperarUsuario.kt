package com.clean.architecture.application.usuario.recuperar

import com.clean.architecture.domain.usuario.UsuarioGateway

class DefaultRecuperarUsuario(val repository: UsuarioGateway) : RecuperarUsuarioUseCase() {

    override fun execute(input: RecuperarUsuarioCommand): RecueperarUsuarioOutput? {
        val usuarioRecuperado = repository.obterUsuario(input.matricula, input.nome)

        return if (usuarioRecuperado != null) RecueperarUsuarioOutput.from(usuarioRecuperado) else null

    }
}

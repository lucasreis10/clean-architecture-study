package com.clean.architecture.application.usuario.recuperar

import com.clean.architecture.application.UseCase
import com.clean.architecture.domain.usuario.UsuarioRepository

class RecuperarUsuario(val repository: UsuarioRepository):
    UseCase<RecuperarUsuarioCommand, RecueperarUsuarioOutput>() {

    override fun execute(input: RecuperarUsuarioCommand): RecueperarUsuarioOutput? {
        val usuarioRecuperado = repository.obterUsuario(input.matricula, input.nome)

        return if (usuarioRecuperado != null) RecueperarUsuarioOutput.from(usuarioRecuperado) else null
    }


}

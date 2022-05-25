package com.clean.architecture.application.usuario.criar

import com.clean.architecture.domain.usuario.Usuario
import com.clean.architecture.domain.usuario.UsuarioGateway

class DefaultCriarUsuarioUseCase(val usuarioGateway: UsuarioGateway): CriarUsuarioUseCase() {

    override fun execute(input: CriarUsuarioCommand): CriarUsuarioOutput {
        val usuario = Usuario.newUsuario(input.nome, input.email, input.endereco, input.telefone)

        usuario.validar()

        return CriarUsuarioOutput.from(usuarioGateway.criarUsuario(usuario))
    }
}

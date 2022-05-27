package com.clean.architecture.domain.usuario


interface UsuarioGateway {

    fun criarUsuario(usuario: Usuario): Usuario

    fun obterUsuario(matricula: String, nome: String): Usuario?

    fun obterUsuario(uuid: String): Usuario?

}

package com.clean.architecture.domain.usuario


interface UsuarioRepository {

    fun criarUsuario(usuario: Usuario): Usuario

    fun obterUsuario(matricula: String, nome: String): Usuario?

}

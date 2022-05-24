package com.clean.architecture.domain.usuario


interface UsuarioRepository {

    fun obterUsuario(matricula: String, nome: String): Usuario?

}

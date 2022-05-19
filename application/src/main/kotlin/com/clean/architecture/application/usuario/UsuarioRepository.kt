package com.clean.architecture.application.usuario

interface UsuarioRepository {

    fun obterUsuario(matricula: String, nome: String): Usuario?

}

package com.clean.architecture.application.usuario

import com.clean.architecture.domain.usuario.Usuario

interface UsuarioRepository {

    fun obterUsuario(matricula: String, nome: String): Usuario?

}

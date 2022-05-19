package com.clean.architecture.domain.domain.usuario

import com.clean.architecture.domain.domain.usuario.entity.Usuario

interface UsuarioRepository {

    fun obterUsuario(matricula: String, nome: String): com.clean.architecture.domain.domain.usuario.entity.Usuario?

}

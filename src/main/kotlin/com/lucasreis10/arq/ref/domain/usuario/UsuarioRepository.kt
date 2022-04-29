package com.lucasreis10.arq.ref.domain.usuario

import com.lucasreis10.arq.ref.domain.usuario.entity.Usuario

interface UsuarioRepository {

    fun obterUsuario(matricula: String, nome: String): Usuario?

}

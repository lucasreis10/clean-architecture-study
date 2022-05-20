package com.clean.architecture.domain.usuario

import com.clean.architecture.domain.excepetion.DominioException

class UsuarioValidator constructor(val usuario: Usuario) {

    fun validar() {
        verificarTamanhoNome()
    }

    private fun verificarTamanhoNome() {
        if(usuario.nome.length <= 3) {
            throw DominioException("Nome do usuário deve conter mais de 3 caracters")
        }
    }

}

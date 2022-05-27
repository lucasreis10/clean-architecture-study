package com.clean.architecture.domain.usuario

import com.clean.architecture.domain.excepetion.DominioException
import java.util.Objects

class UsuarioValidator constructor(val usuario: Usuario) {

    fun validar() {
        verificarTamanhoNome()
        verificarMatriculaNull()
    }

    private fun verificarTamanhoNome() {
        if(usuario.nome.length <= 3) {
            throw DominioException("Nome do usuário deve conter mais de 3 caracters.")
        }
    }

    private fun verificarMatriculaNull() {
        Objects.requireNonNull(usuario.matricula,
            "Matrícula do usuário obrigatório.")
    }

}

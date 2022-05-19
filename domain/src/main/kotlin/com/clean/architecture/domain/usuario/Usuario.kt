package com.clean.architecture.domain.usuario

import com.clean.architecture.domain.domain.emprestimo.entity.Emprestimo
import com.clean.architecture.domain.domain.excepetion.DominioException

class Usuario(
    val matricula: String,
    val nome: String,
    val email: String,
    val endereco: String,
    val telefone: String,
    val emprestimos: List<com.clean.architecture.domain.domain.emprestimo.entity.Emprestimo>,
) {

    init {
        validar()
    }

    fun validar() {
        if(this.matricula.length <= 3) {
            throw com.clean.architecture.domain.domain.excepetion.DominioException("Matricula deve conter mais de 3 caracters")
        }
    }

}

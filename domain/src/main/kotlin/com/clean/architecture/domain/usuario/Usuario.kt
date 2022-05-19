package com.clean.architecture.domain.usuario

import com.clean.architecture.domain.emprestimo.Emprestimo
import com.clean.architecture.domain.excepetion.DominioException

class Usuario(
    val matricula: String,
    val nome: String,
    val email: String,
    val endereco: String,
    val telefone: String,
    val emprestimos: List<Emprestimo>,
) {

    init {
        validar()
    }

    fun validar() {
        if(this.matricula.length <= 3) {
            throw DominioException("Matricula deve conter mais de 3 caracters")
        }
    }

}

package com.lucasreis10.arq.ref.domain.usuario.entity

import com.lucasreis10.arq.ref.domain.emprestimo.entity.Emprestimo
import com.lucasreis10.arq.ref.domain.excepetion.DominioException

class Usuario(
    val matricula: String,
    val nome: String,
    val email: String,
    val endereco: String,
    val telefone: String,
    val emprestimos: List<Emprestimo>,
) {

    fun validar() {
        if(this.matricula.length <= 3) {
            DominioException("Matricula deve conter mais de 3 caracters")
        }
    }

}

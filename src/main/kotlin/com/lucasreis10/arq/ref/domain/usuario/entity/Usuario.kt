package com.lucasreis10.arq.ref.domain.usuario.entity

import com.lucasreis10.arq.ref.domain.emprestimo.entity.Emprestimo

class Usuario(
    val matricula: String,
    val nome: String,
    val email: String,
    val endereco: String,
    val telefone: String,
    val emprestimos: List<Emprestimo>
) {

}

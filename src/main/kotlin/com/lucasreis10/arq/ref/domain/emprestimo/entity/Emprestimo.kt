package com.lucasreis10.arq.ref.domain.emprestimo.entity

import com.lucasreis10.arq.ref.domain.usuario.entity.Usuario
import java.util.Date

class Emprestimo(
    val codigo: Int,
    val dataHora: Date,
    val dataDevolucao: Date,
    val usuario: Usuario
) {

}

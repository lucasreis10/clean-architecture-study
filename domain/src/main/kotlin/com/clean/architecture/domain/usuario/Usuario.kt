package com.clean.architecture.domain.usuario

import com.clean.architecture.domain.AggregateRoot
import com.clean.architecture.domain.excepetion.DominioException
import java.time.Instant
import java.time.Year
import java.util.UUID

class Usuario private constructor(
    val id: UsuarioId,
    val matricula: String,
    val nome: String,
    val email: String,
    val endereco: String,
    val telefone: String,
    val dataCriacao: Instant,
    val dataInativacao: Instant?,
    val ativo: Boolean
): AggregateRoot<UsuarioId>(id) {

    init {
        validar()
    }

    fun validar() {
        if(this.nome.length <= 3) {
            throw DominioException("Nome do usuário deve conter mais de 3 caracters")
        }
    }

    companion object {
        fun newUsuario(nome: String, email: String, endereco: String, telefone: String): Usuario {
            val id = UsuarioId.gerar()
            val matricula = gerarMatricula()

            return Usuario(id, matricula, nome, email, endereco, telefone, Instant.now(), null, true)
        }

        private fun gerarMatricula(): String {
            val anoAtual = Year.now().value.toString()
            val uuid = UUID.randomUUID().toString()

            return "$anoAtual-$uuid"
        }
    }

}

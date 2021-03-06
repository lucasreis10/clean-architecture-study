package com.clean.architecture.domain.usuario

import com.clean.architecture.domain.AggregateRoot
import java.time.Instant
import java.time.Year
import java.util.*

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

    override fun validar() {
        UsuarioValidator(this).validar()
    }


    fun inativarUsuario(): Usuario {
        return Usuario(id, matricula, nome, email, endereco, telefone, dataCriacao, Instant.now(), false)
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

        fun with(
            id: String,
            matricula: String,
            nome: String,
            email: String,
            endereco: String,
            telefone: String,
            dataCriacao: Instant,
            dataInativacao: Instant?,
            ativo: Boolean
        ): Usuario {
            return Usuario(
                UsuarioId.from(id),
                matricula,
                nome,
                email,
                endereco,
                telefone,
                dataCriacao,
                dataInativacao,
                ativo
            )
        }
    }

}

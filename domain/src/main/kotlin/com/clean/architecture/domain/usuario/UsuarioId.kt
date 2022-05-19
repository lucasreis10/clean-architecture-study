package com.clean.architecture.domain.usuario

import java.util.Objects
import java.util.UUID

class UsuarioId private constructor(
    val id: String
){

    init {
        Objects.nonNull(id)
    }

    companion object {
        fun gerar(): UsuarioId {
            return from(UUID.randomUUID())
        }

        fun from(id: String): UsuarioId {
            return UsuarioId(id)
        }

        fun from(id: UUID): UsuarioId {
            return UsuarioId(id.toString())
        }

    }

}

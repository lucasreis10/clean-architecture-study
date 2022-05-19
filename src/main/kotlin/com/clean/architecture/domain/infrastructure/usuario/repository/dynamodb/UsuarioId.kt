package com.clean.architecture.domain.infrastructure.usuario.repository.dynamodb

import software.amazon.awssdk.enhanced.dynamodb.Key

class UsuarioId {


    companion object {
        val prefixo: String = "usuario-"

        fun criarChave(pk: String, sk: String): Key {
            return Key.builder()
                .partitionValue(prefixo+pk)
                .sortValue(sk)
                .build()
        }
    }

}

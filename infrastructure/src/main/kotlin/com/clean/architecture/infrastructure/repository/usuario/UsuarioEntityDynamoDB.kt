package com.clean.architecture.infrastructure.repository.usuario
import com.clean.architecture.domain.usuario.Usuario
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import java.time.Instant

@DynamoDbBean
class UsuarioEntityDynamoDB(
    @get:DynamoDbPartitionKey
    val id: String,
    val matricula: String,
    val nome: String,
    val email: String,
    val endereco: String,
    val telefone: String,
    val dataCriacao: Instant,
    val dataInativacao: Instant?,
    val ativo: Boolean
) {

    companion object {
        fun from(usuario: Usuario): UsuarioEntityDynamoDB {
            return UsuarioEntityDynamoDB(
            usuario.id.toString(),
            usuario.matricula,
            usuario.nome,
            usuario.email,
            usuario.endereco,
            usuario.telefone,
            usuario.dataCriacao,
            usuario.dataInativacao,
            usuario.ativo
            )
        }
    }

    fun mutate(): Usuario {
        return Usuario.with(
            id,
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

package com.clean.architecture.infrastructure.repository.usuario

import com.clean.architecture.domain.usuario.Usuario
import com.clean.architecture.domain.usuario.UsuarioGateway
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UsuarioGatewayDynamoDB(
    dynamoDBClient: DynamoDbEnhancedClient): UsuarioGateway {

    private val tableUsuario = dynamoDBClient.table("usuario", TableSchema.fromBean(UsuarioEntityDynamoDB::class.java))


    override fun criarUsuario(usuario: Usuario): Usuario {
        val usuarioConvertido = UsuarioEntityDynamoDB.from(usuario)

        tableUsuario.putItem(usuarioConvertido)

        return usuario
    }

    override fun obterUsuario(matricula: String, nome: String): Usuario? {
        val usuarioKey = Key.builder().partitionValue(matricula).sortValue(nome).build()

        val usuario = tableUsuario.getItem(usuarioKey)

        return usuario.mutate()
    }

    override fun obterUsuario(uuid: String): Usuario? {
        val usuarioKey = Key.builder().partitionValue(uuid).build()

        val usuario = tableUsuario.getItem(usuarioKey)

        return usuario.mutate()
    }
}

package com.clean.architecture.infrastructure.repository.dynamodb.usuario

import com.clean.architecture.application.usuario.UsuarioRepository
import com.clean.architecture.domain.usuario.Usuario
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.TableSchema.fromBean
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DynamoDbRepositoryUsuario(
    private val dynamoDbClient: DynamoDbEnhancedClient,
    private val usuarioModelConverter: UsuarioModelConverter
    ):UsuarioRepository {

    override fun obterUsuario(matricula: String, nome: String): Usuario? {
        val usuarioTable = dynamoDbClient.table("biblioteca", fromBean(UsuarioModel::class.java))
        val usuarioId = UsuarioId.criarChave(matricula, nome)

        val usuarioModel = usuarioTable.getItem(usuarioId)

        return usuarioModelConverter.converterParaEntidade(usuarioModel)
    }

}

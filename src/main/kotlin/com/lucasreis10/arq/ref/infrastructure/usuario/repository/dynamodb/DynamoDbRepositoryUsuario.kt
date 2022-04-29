package com.lucasreis10.arq.ref.infrastructure.usuario.repository.dynamodb

import com.lucasreis10.arq.ref.domain.usuario.UsuarioRepository
import com.lucasreis10.arq.ref.domain.usuario.entity.Usuario
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.TableSchema.fromBean
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DynamoDbRepositoryUsuario(
    private val dynamoDbClient: DynamoDbEnhancedClient,
    private val usuarioModelConverter: UsuarioModelConverter
    ): UsuarioRepository{

    override fun obterUsuario(matricula: String, nome: String): Usuario? {
        val usuarioTable = dynamoDbClient.table("biblioteca", fromBean(UsuarioModel::class.java))
        val usuarioId = UsuarioId.criarChave(matricula, nome)

        val usuarioModel = usuarioTable.getItem(usuarioId)

        return usuarioModelConverter.converterParaEntidade(usuarioModel)
    }

}

package com.clean.architecture.infrastructure.repository

import com.clean.architecture.domain.infrastructure.emprestimo.dynamodb.EmprestimoModel
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
class UsuarioModel(

    @get:DynamoDbPartitionKey
    val matricula: String,
    @get:DynamoDbSortKey
    val nome: String,
    val email: String,
    val endereco: String,
    val telefone: String,
    val emprestimos: List<com.clean.architecture.domain.infrastructure.emprestimo.dynamodb.EmprestimoModel>
) {

}

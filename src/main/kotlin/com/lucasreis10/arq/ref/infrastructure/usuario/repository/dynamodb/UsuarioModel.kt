package com.lucasreis10.arq.ref.infrastructure.usuario.repository.dynamodb

import com.lucasreis10.arq.ref.infrastructure.emprestimo.dynamodb.EmprestimoModel
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
    val emprestimos: List<EmprestimoModel>
) {

}

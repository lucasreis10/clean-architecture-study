package com.clean.architecture.domain.infrastructure.emprestimo.dynamodb

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import java.util.*

@DynamoDbBean
class EmprestimoModel(
    val codigo: Int,
    val dataHora: Date,
    val dataDevolucao: Date,
){

}

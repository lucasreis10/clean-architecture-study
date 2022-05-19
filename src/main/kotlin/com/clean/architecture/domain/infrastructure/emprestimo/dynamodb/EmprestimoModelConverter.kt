package com.clean.architecture.domain.infrastructure.emprestimo.dynamodb

import com.clean.architecture.domain.domain.emprestimo.entity.Emprestimo
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class EmprestimoModelConverter {

    fun converterParaEntidade(emprestimoModel: com.clean.architecture.domain.infrastructure.emprestimo.dynamodb.EmprestimoModel?): com.clean.architecture.domain.domain.emprestimo.entity.Emprestimo? {
        return if(emprestimoModel != null)
            com.clean.architecture.domain.domain.emprestimo.entity.Emprestimo(
                emprestimoModel.codigo,
                emprestimoModel.dataHora,
                emprestimoModel.dataDevolucao
            )
        else
            null
    }

    fun converterParaEntidade(lista: List<com.clean.architecture.domain.infrastructure.emprestimo.dynamodb.EmprestimoModel>): List<com.clean.architecture.domain.domain.emprestimo.entity.Emprestimo> {
        return lista.map { converterParaEntidade(it)!! }
    }
}

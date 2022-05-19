package com.clean.architecture.infrastructure.repository.dynamodb.emprestimo

import com.clean.architecture.domain.emprestimo.Emprestimo
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class EmprestimoModelConverter {

    fun converterParaEntidade(emprestimoModel: EmprestimoModel?): Emprestimo? {
        return if(emprestimoModel != null)
            Emprestimo(
                emprestimoModel.codigo,
                emprestimoModel.dataHora,
                emprestimoModel.dataDevolucao
            )
        else
            null
    }

    fun converterParaEntidade(lista: List<EmprestimoModel>): List<Emprestimo> {
        return lista.map { converterParaEntidade(it)!! }
    }
}

package com.lucasreis10.arq.ref.infrastructure.emprestimo.dynamodb

import com.lucasreis10.arq.ref.domain.emprestimo.entity.Emprestimo
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class EmprestimoModelConverter {

    fun converterParaEntidade(emprestimoModel: EmprestimoModel?): Emprestimo? {
        return if(emprestimoModel != null)
            Emprestimo(emprestimoModel.codigo, emprestimoModel.dataHora, emprestimoModel.dataDevolucao)
        else
            null
    }

    fun converterParaEntidade(lista: List<EmprestimoModel>): List<Emprestimo> {
        return lista.map { converterParaEntidade(it)!! }
    }
}

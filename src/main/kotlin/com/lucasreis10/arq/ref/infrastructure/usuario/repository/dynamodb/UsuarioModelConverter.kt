package com.lucasreis10.arq.ref.infrastructure.usuario.repository.dynamodb

import com.lucasreis10.arq.ref.domain.usuario.entity.Usuario
import com.lucasreis10.arq.ref.infrastructure.emprestimo.dynamodb.EmprestimoModelConverter
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UsuarioModelConverter(private val emprestimoModelConverter: EmprestimoModelConverter) {

    fun converterParaEntidade(usuarioModel: UsuarioModel?): Usuario? {
        return if(usuarioModel != null)
            Usuario(
                usuarioModel.matricula,
                usuarioModel.nome,
                usuarioModel.email,
                usuarioModel.endereco,
                usuarioModel.telefone,
                emprestimoModelConverter.converterParaEntidade(usuarioModel.emprestimos)
            )
        else null
    }

}

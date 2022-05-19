package com.clean.architecture.infrastructure.repository.dynamodb.usuario

import com.clean.architecture.domain.domain.usuario.entity.Usuario
import com.clean.architecture.domain.infrastructure.emprestimo.dynamodb.EmprestimoModelConverter
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UsuarioModelConverter(private val emprestimoModelConverter: com.clean.architecture.domain.infrastructure.emprestimo.dynamodb.EmprestimoModelConverter) {

    fun converterParaEntidade(usuarioModel: UsuarioModel?): com.clean.architecture.domain.domain.usuario.entity.Usuario? {
        return if(usuarioModel != null)
            com.clean.architecture.domain.domain.usuario.entity.Usuario(
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

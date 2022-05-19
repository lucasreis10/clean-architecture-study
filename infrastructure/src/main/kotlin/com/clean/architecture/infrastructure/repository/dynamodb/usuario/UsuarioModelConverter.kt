package com.clean.architecture.infrastructure.repository.dynamodb.usuario

import com.clean.architecture.domain.usuario.Usuario
import com.clean.architecture.infrastructure.repository.dynamodb.emprestimo.EmprestimoModelConverter
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

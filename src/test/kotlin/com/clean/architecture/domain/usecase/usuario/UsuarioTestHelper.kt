package com.clean.architecture.domain.usecase.usuario

import com.clean.architecture.domain.domain.usuario.UsuarioRepository
import com.clean.architecture.domain.domain.usuario.entity.Usuario
import com.lucasreis10.arq.ref.usecase.usuario.obter.OutputUsuarioDto

object ObterUsuarioTestHelper {

    fun usuarioDummy(matricula: String = "dummy-matricula",
                     nome: String = "dummy-nome",
                     email: String = "dummy-email",
                     endereco: String = "dummy-endereco",
                     telefone: String = "dummy-telefone"
                     ): OutputUsuarioDto {
        return OutputUsuarioDto(matricula, nome, email, endereco, telefone)
    }

}

class UsuarioRepositoryMock: com.clean.architecture.domain.domain.usuario.UsuarioRepository {
    override fun obterUsuario(matricula: String, nome: String): com.clean.architecture.domain.domain.usuario.entity.Usuario {
        return com.clean.architecture.domain.domain.usuario.entity.Usuario(
            "12345",
            "Lucas",
            "lucas@email.com",
            "Avenida 3 lote 2 casa 1",
            "(61) 3331-3992",
            emptyList()
        )
    }

}

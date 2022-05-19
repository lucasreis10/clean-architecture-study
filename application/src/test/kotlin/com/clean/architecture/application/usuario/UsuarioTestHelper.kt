package com.clean.architecture.application.usuario

import com.clean.architecture.application.usuario.obter.OutputUsuarioDto
import com.clean.architecture.domain.usuario.Usuario

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

class UsuarioRepositoryMock: UsuarioRepository {
    override fun obterUsuario(matricula: String, nome: String): Usuario {
        return Usuario.newUsuario(
            "Lucas",
            "lucas@email.com",
            "Avenida 3 lote 2 casa 1",
            "(61) 3331-3992",
        )
    }

}

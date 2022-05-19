package com.clean.architecture.domain.usuario

import com.clean.architecture.domain.domain.emprestimo.entity.Emprestimo


object UsuarioTestHelper {

    fun usuario(matricula: String = "1234",
                nome: String = "Maria",
                email: String = "maria@email.com",
                endereco: String = "Rua 1 lote 2 casa 3",
                telefone: String = "99 3242-3242",
    ): com.clean.architecture.domain.domain.usuario.entity.Usuario =
        com.clean.architecture.domain.domain.usuario.entity.Usuario(
            matricula,
            nome,
            email,
            endereco,
            telefone,
            emptyList()
        )

}

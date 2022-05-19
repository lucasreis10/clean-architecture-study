package com.clean.architecture.domain.usuario


object UsuarioTestHelper {

    fun usuario(matricula: String = "1234",
                nome: String = "Maria",
                email: String = "maria@email.com",
                endereco: String = "Rua 1 lote 2 casa 3",
                telefone: String = "99 3242-3242",
    ): Usuario =
        Usuario(
            matricula,
            nome,
            email,
            endereco,
            telefone,
            emptyList()
        )

}

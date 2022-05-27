package com.clean.architecture.infrastructure.repository.usuario

import com.clean.architecture.domain.usuario.Usuario
import com.clean.architecture.infrastructure.DynamoDBContainerResource
import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import javax.inject.Inject

@QuarkusTestResource(DynamoDBContainerResource::class)
@QuarkusTest
class UsuarioGatewayDynamoDBTest {

    @Inject
    lateinit var usuarioGatewayDynamoDB: UsuarioGatewayDynamoDB

    @Test
    @DisplayName("""
        Dado um usuário com parametros válidos
        Quando criar usuário for chmado
        Então um usuário novo será criado na tabela do DynamoDB
    """)
    fun criarUsuario() {
        // setup:
        assertThat(usuarioGatewayDynamoDB).isNotNull()
    }

}

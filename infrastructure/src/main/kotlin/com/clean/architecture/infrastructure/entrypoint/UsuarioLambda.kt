package com.clean.architecture.infrastructure.entrypoint

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.inject.Named


@Named("usuario")
class UsuarioLambda: RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent?> {

    @Inject
    @field:Default
    private lateinit var obterTodosUsuariosHandle: ObterTodosUsuariosHandle

    override fun handleRequest(request: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent? {
        val httphMethod = request.httpMethod

        return when(httphMethod) {
            "GET" -> obterTodosUsuariosHandle.execute(request, context)

            else -> null
        }
    }
}

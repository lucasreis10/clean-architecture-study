package com.lucasreis10.arq.ref.infrastructure.usuario.entrypoint.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse
import javax.inject.Named


@Named("usuario")
class UsuarioHandle: RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse?> {

    override fun handleRequest(input: APIGatewayV2HTTPEvent?, context: Context?): APIGatewayV2HTTPResponse? {
        return null
    }
}

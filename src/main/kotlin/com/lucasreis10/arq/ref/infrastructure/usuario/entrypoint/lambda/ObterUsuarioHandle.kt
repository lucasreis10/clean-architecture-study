package com.lucasreis10.arq.ref.infrastructure.usuario.entrypoint.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse
import com.lucasreis10.arq.ref.infrastructure.config.usecase.UsesCaseConfig
import com.lucasreis10.arq.ref.usecase.usuario.obter.InputObterUsuarioDto
import com.lucasreis10.arq.ref.usecase.usuario.obter.ObterUsuario
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ObterUsuarioHandle: RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse>  {

    override fun handleRequest(event: APIGatewayV2HTTPEvent, context: Context): APIGatewayV2HTTPResponse {
        val obterUsuario: ObterUsuario = UsesCaseConfig().obterUsuario()

        val logger = context.logger

        val command = try {
            Json.decodeFromString<InputObterUsuarioCommand>(event.body)
        } catch (e: Exception) {
            logger.log(e.message)
            return APIGatewayV2HTTPResponse().apply {
                statusCode = 400
                headers = mapOf("Content-Type" to "application/json")
                body = """{"message": "Failed to parse product from request body"}"""
            }
        }
        val iputObterUsuarioDto = InputObterUsuarioDto(command.matricula, command.nome)

        val usuario = obterUsuario.execute(iputObterUsuarioDto)

        return APIGatewayV2HTTPResponse().apply {
            statusCode = 200
            headers = mapOf("Content-Type" to "application/json")
        }
    }
}

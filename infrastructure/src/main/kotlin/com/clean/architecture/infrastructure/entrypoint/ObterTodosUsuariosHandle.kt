package com.clean.architecture.infrastructure.entrypoint

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.clean.architecture.application.usuario.recuperar.RecuperarUsuario
import com.clean.architecture.application.usuario.recuperar.InputObterUsuarioDto
import com.clean.architecture.application.usuario.recuperar.OutputUsuarioDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class ObterTodosUsuariosHandle(private val obterUsuarioUseCase: RecuperarUsuario) {

    fun execute(event: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent {
        val command = converterRequestParaObjeto(event)
        val iputObterUsuarioDto = converterParaInputUseCase(command)

        val output = obterUsuarioUseCase.execute(iputObterUsuarioDto)

        return response(output)
    }

    private fun response(output: OutputUsuarioDto?) =
        APIGatewayProxyResponseEvent().apply {
            body = output.toString()
            statusCode = 200
            headers = mapOf("Content-Type" to "application/json")
        }

    private fun converterParaInputUseCase(command: InputObterUsuarioCommand) =
        InputObterUsuarioDto(command.matricula, command.nome)

    fun converterRequestParaObjeto(event: APIGatewayProxyRequestEvent): InputObterUsuarioCommand {
        try {
            return Json.decodeFromString<InputObterUsuarioCommand>(event.body)
        } catch (exception: Exception) {
            throw exception
        }
    }

}


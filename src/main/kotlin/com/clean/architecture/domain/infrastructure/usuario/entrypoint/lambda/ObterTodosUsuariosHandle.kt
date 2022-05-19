package com.clean.architecture.domain.infrastructure.usuario.entrypoint.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.lucasreis10.arq.ref.usecase.usuario.obter.InputObterUsuarioDto
import com.lucasreis10.arq.ref.usecase.usuario.obter.ObterUsuario
import com.lucasreis10.arq.ref.usecase.usuario.obter.OutputUsuarioDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class ObterTodosUsuariosHandle(private val obterUsuarioUseCase: ObterUsuario) {

    fun execute(event: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent {
        val command = converterRequestParaObjeto(event)
        val iputObterUsuarioDto = converterParaInputUseCase(command)

        val output = obterUsuarioUseCase.execute(iputObterUsuarioDto)

        return response(output)
    }

    private fun response(output: OutputUsuarioDto?) =
        APIGatewayProxyResponseEvent().apply {
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

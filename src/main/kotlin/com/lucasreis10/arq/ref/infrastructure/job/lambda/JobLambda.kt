package com.lucasreis10.arq.ref.infrastructure.job.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.lucasreis10.arq.ref.usecase.job.fetch.FetchJobUseCase
import com.lucasreis10.arq.ref.usecase.job.fetch.InputFetchJobDto
import java.util.*

class JobLambda(
    private val fetchJobUseCase: FetchJobUseCase
    ): RequestHandler<InputFetchJobLambdaDto, OutputFetchJobLambdaDto> {


    override fun handleRequest(input: InputFetchJobLambdaDto?, context: Context?): OutputFetchJobLambdaDto {
        val inputUseCase = InputFetchJobDto(input!!.pk, input.job)

        val outputUseCase = fetchJobUseCase.execute(inputUseCase)

        return OutputFetchJobLambdaDto(
            outputUseCase?.image!!,
            outputUseCase.images,
            outputUseCase.gsi1pk,
            outputUseCase.gsi1sk
        )
    }
}


data class InputFetchJobLambdaDto(
    val pk: String,
    val job: String,
)

data class OutputFetchJobLambdaDto(
    val image: String,
    val images: List<String>,
    val gsi1pk: String,
    val gsi1sk: Date
)

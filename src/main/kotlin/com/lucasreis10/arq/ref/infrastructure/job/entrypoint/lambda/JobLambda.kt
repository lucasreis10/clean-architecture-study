package com.lucasreis10.arq.ref.infrastructure.job.entrypoint.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.lucasreis10.arq.ref.usecase.job.fetch.FetchJobUseCase
import com.lucasreis10.arq.ref.usecase.job.fetch.InputFetchJobDto
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.inject.Named

@Named("JobLambda")
class JobLambda: RequestHandler<InputFetchJobLambdaDto, Any> {

    @Inject
    @field: Default
    private lateinit var fetchJobUseCase: FetchJobUseCase

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

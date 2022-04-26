package com.lucasreis10.arq.ref.infrastructure.config.aws.lambda

import com.lucasreis10.arq.ref.infrastructure.job.repository.dynamodb.JobRepository
import com.lucasreis10.arq.ref.usecase.job.fetch.FetchJobUseCase
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.Produces


@ApplicationScoped
class LambdaBeanConfig(private val jobRepository: JobRepository) {

    @Produces
    fun fetchJobUaseCase(): FetchJobUseCase {
        return FetchJobUseCase(jobRepository)
    }

}

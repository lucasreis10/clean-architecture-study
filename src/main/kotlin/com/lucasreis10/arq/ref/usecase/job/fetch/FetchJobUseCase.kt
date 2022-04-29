package com.lucasreis10.arq.ref.usecase.job.fetch

import com.lucasreis10.arq.ref.usecase.job.JobRepositoryInterface
import com.lucasreis10.arq.ref.domain.job.entity.Job

class FetchJobUseCase(private val jobRepository: JobRepositoryInterface) {

    fun execute(input: InputFetchJobDto): OutputFetchJobDto? {
        val job = jobRepository.fetchJob(input.pk, input.job)


        return toOutput(job)
    }

    private fun toOutput(job: Job?): OutputFetchJobDto? {
        if(job == null) return null
        return OutputFetchJobDto(
            job.gsi1pk,
            job.gsi1sk,
            job.gsi2sk,
            job.created,
            job.updated,
            job.image,
            job.images,
            job.syncedImages,
            job.scope,
            job.model,
            job.callbackUrl,
            job.updatedBy,
            job.approvedBy,
        )
    }
}

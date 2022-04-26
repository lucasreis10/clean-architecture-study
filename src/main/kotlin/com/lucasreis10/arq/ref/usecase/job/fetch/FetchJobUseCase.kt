package com.lucasreis10.arq.ref.usecase.job.fetch

import com.lucasreis10.arq.ref.domain.job.JobRepositoryInterface
import com.lucasreis10.arq.ref.domain.job.entity.Job

class FetchJobUseCase(private val jobRepository: JobRepositoryInterface) {

    fun execute(input: InputFindJobDto): OutputFindJobDto? {
        val job = jobRepository.fetchJob(input.pk, input.job)

        return convertToOutput(job)
    }

    private fun convertToOutput(job: Job?): OutputFindJobDto? {
        if(job == null) return null
        return OutputFindJobDto(
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

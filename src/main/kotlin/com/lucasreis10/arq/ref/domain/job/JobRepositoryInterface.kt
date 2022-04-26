package com.lucasreis10.arq.ref.domain.job

import com.lucasreis10.arq.ref.domain.job.entity.Job

interface JobRepositoryInterface {

    fun fetchJob(pk: String, job: String): Job?

}

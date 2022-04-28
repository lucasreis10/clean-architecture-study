package com.lucasreis10.arq.ref.usecase.job.fetch

import com.lucasreis10.arq.ref.domain.job.entity.Job
import java.util.*

object FetchJobTestHelper {

    fun inputFindJobDto(pk: String = "dummy", job: String = "dummy"): InputFetchJobDto {
      return InputFetchJobDto(pk, job)
    }

    fun job(): Job {
        val date = Date()
        return Job(
            "pk-1234",
            date,
            date,
            date,
            date,
            "dummy",
            arrayListOf("dummy"),
            2,
            "dummy",
            "dummy",
            "dummy",
            "dummy",
            "dummy"
        )
    }
}

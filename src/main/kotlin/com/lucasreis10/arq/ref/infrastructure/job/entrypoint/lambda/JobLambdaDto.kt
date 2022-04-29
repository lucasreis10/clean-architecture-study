package com.lucasreis10.arq.ref.infrastructure.job.entrypoint.lambda

import java.util.*


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

package com.lucasreis10.arq.ref.usecase.job.fetch

import java.util.*

data class InputFindJobDto(
    val pk: String,
    val job: String,
)

data class  OutputFindJobDto(
    val gsi1pk: String,
    val gsi1sk: Date,
    val gsi2sk: Date,
    val created: Date,
    val updated: Date,
    val image: String,
    val images: List<String>,
    val syncedImages: Int,
    val scope: String,
    val model: String,
    val callbackUrl: String,
    val updatedBy: String,
    val approvedBy: String
)

package com.lucasreis10.arq.ref.domain.job.entity

import java.util.*

class Job constructor(
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
) {

}

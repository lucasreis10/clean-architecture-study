package com.lucasreis10.arq.ref.infrastructure.job.repository.dynamodb

import com.lucasreis10.arq.ref.domain.job.entity.Job
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey
import java.util.*

@DynamoDbBean
class JobModel(

    @get:DynamoDbPartitionKey
    val gsi1pk: String,
    @get:DynamoDbSortKey
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
    fun toJob(): Job? {
        return Job(this.gsi1pk,
                this.gsi1sk,
                this.gsi2sk,
                this.created,
                this.updated,
                this.image,
                this.images,
                this.syncedImages,
                this.scope,
                this.model,
                this.callbackUrl,
                this.updatedBy,
                this.approvedBy)
    }

    companion object {
        fun tableName() = "eyes-api"

    }

}

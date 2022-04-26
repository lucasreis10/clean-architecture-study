package com.lucasreis10.arq.ref.infrastructure.job.repository.dynamodb

import com.lucasreis10.arq.ref.domain.job.entity.Job
import com.lucasreis10.arq.ref.domain.job.JobRepositoryInterface
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
class JobRepository: JobRepositoryInterface {

    @Inject
    @field: Default
    lateinit var dynamoDbClient: DynamoDbEnhancedClient


    override fun fetchJob(pk: String, job: String): Job? {
        val table = dynamoDbClient.table(JobModel.tableName(), TableSchema.fromBean(JobModel::class.java))
        val jobKey = Key.builder().partitionValue(pk).sortValue(job).build()

        val jobModel:JobModel = table.getItem(jobKey)

        return jobModel.toJob()
    }

}

package com.lucasreis10.arq.ref.infrastructure

import org.testcontainers.containers.GenericContainer
import org.testcontainers.utility.DockerImageName

class DynamoDbTestResource: QuarkusTestResource {

    private val dynamoDb = GenericContainer<Nothing>(
        DockerImageName
        .parse("amazon/dynamodb-local:1.11.477")).apply {
        withCommand("-jar DynamoDBLocal.jar -inMemory -sharedDb")
        withExposedPorts(8000, 8000)
        withEnv(getSystemVariable())
    }

    fun getSystemVariable(): MutableMap<String, String> {
        val AWS_ACESS_KEY_ID = "AWS_ACCESS_KEY_ID"
        val awsAccesKey = System.getenv(AWS_ACESS_KEY_ID)
        val envSystem = mutableMapOf<String, String>()

        if(awsAccesKey.isNullOrBlank()) {
            envSystem[AWS_ACESS_KEY_ID] = "fake"
        }
        return envSystem
    }

    override fun start(): MutableMap<String, String> {
        dynamoDb.start()
        println("############  Started DynamoDB ${dynamoDb.getMappedPort(8000)}  ############")

        return mutableMapOf(
            "quarkus.dynamodb.endpoint-override" to "http://localhost:${dynamoDb.getMappedPort(8000)}",
            "quarkus.dynamodb.aws.region" to "eu-central-1",
            "dynamo.table.movie-table" to "movie",
            "aws.accessKeyId" to "fake",
        )
    }

    override fun stop() {
        print("Stop DynamoDB")
        dynamoDb.stop()
    }
}

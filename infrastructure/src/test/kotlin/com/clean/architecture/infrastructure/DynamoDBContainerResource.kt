package com.clean.architecture.infrastructure

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager
import org.testcontainers.containers.GenericContainer

class DynamoDBContainerResource: QuarkusTestResourceLifecycleManager {

    private val dynamodb = GenericContainer("amazon/dynamodb-local:1.11.477")
        .withCommand("-jar DynamoDBLocal.jar -inMemory -sharedDb")
        .withExposedPorts(8000, 8000)
        .withEnv(variavelAmbiente())

    fun variavelAmbiente(): MutableMap<String, String> {
        val awsAccesKey = System.getenv("accesskey")
        val envSystem = mutableMapOf<String, String>()

        if(awsAccesKey.isNullOrBlank()) {
            envSystem["accesskey"] = "fake-key"
        }
        return envSystem
    }

    override fun start(): MutableMap<String, String> {
        dynamodb.start()
        println("############  Started DynamoDB ${dynamodb.getMappedPort(8000)}  ############")

        return mutableMapOf(
            "quarkus.dynamodb.endpoint-override" to "http://localhost:${dynamodb.getMappedPort(8000)}",
            "quarkus.dynamodb.aws.region" to "eu-central-1",
            "dynamo.table.movie-table" to "movie",
            "aws.accessKeyId" to "fake",
        )
    }

    override fun stop() {
        dynamodb.stop()
    }
}

package com.clean.architecture.domain.infrastructure.config.aws.dynamodb

import org.eclipse.microprofile.config.inject.ConfigProperty
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.Produces

class DynamoDbClientConfig  (
    @ConfigProperty(name = "quarkus.dynamodb.aws.region")
    private val region: String,
    @ConfigProperty(name = "quarkus.dynamodb.endpoint-override")
    private val endpoint: String
){

    @Produces
    @ApplicationScoped
    fun dynamoDbClient(): DynamoDbClient {
        return DynamoDbClient.builder()
            .region(Region.of(region))
            .endpointOverride(URI.create(endpoint))
            .credentialsProvider(DefaultCredentialsProvider.builder().build())
            .build()
    }

    @Produces
    @ApplicationScoped
    fun dynamoDbEnhancedClient(): DynamoDbEnhancedClient {
        return DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient())
            .build()
    }
}

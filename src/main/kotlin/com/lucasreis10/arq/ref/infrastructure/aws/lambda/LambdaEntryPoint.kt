package com.lucasreis10.arq.ref.infrastructure.aws.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

class LambdaEntryPoint: RequestHandler<Map<String, Any>, Any> {

    override fun handleRequest(input: Map<String, Any>, context: Context?): Any {
        val message = input["message"]

        return message!!
    }
}

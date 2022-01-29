package com.heyoh.models.result

import com.heyoh.models.response.ApiErrorResponse

sealed class Failure {
    object NetworkConnection: Failure()
    object ServerError: Failure()
    object Unexpected: Failure()
    data class ClientError(
        val apiErrorResponse: ApiErrorResponse
    ): Failure()
}
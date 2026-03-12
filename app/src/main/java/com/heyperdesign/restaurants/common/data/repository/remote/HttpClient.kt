package com.heyperdesign.restaurants.common.data.repository.remote

import com.heyperdesign.restaurants.common.data.exception.RestaurantsException
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


fun provideHttpClient(json: Json) = HttpClient(Android) {
    expectSuccess = true
    install(ContentNegotiation) {
        json()
    }
    install(Logging) {
        level = LogLevel.ALL
        logger = Logger.ANDROID
    }
    install(HttpTimeout) {
        requestTimeoutMillis = 30_000
        connectTimeoutMillis = 60_000
        socketTimeoutMillis = 20_000
    }
    defaultRequest {
        url("")
        contentType(ContentType.Application.Json)
    }
    HttpResponseValidator {
        handleResponseExceptionWithRequest { exception, request ->
            if (exception is ResponseException) throw handleResponseException(
                exception.response,
                json
            )
        }
    }

}

private suspend fun handleResponseException(
    response: HttpResponse,
    json: Json,
): RestaurantsException {
    when (val statusCode = response.status.value) {
        HttpStatusCode.Unauthorized.value -> throw RestaurantsException.Client.UnAuthorized(message = response.status.description)
        HttpStatusCode.UnprocessableEntity.value -> {
            val responseBodyText = response.bodyAsText()
            return responseValidationMapping(
                json.decodeFromString<APIErrorResponse>(
                    responseBodyText
                )
            )
        }

        HttpStatusCode.NotFound.value -> throw RestaurantsException.Client.NotFound(message = response.status.description)

        HttpStatusCode.InternalServerError.value -> return RestaurantsException.Server.InternalServerError(
            httpErrorCode = statusCode, message = response.status.description
        )
        else -> throw RestaurantsException.Client.Unhandled(
            errorCode = statusCode, message = response.status.description
        )
    }
}

private fun responseValidationMapping(errorResponse: APIErrorResponse): RestaurantsException {
    return RestaurantsException.Client.ResponseValidation(
        errors = errorResponse.errors?.mapNotNull { (key, value) ->
            if (key == ErrorKeyEnum.UNKNOWN) null else key to value.first()
        }?.toMap() ?: emptyMap(), message = errorResponse.message
    )
}
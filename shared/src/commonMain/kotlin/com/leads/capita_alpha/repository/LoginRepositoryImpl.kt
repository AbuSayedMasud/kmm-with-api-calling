package com.example.ktorimplementing.repository

import com.example.ktorimplementing.model.ApiResponse
import com.example.ktorimplementing.model.LoginRepository
import com.example.ktorimplementing.model.LoginRequest
import com.example.ktorimplementing.model.Result
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.readText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class LoginRepositoryImpl : LoginRepository {
    override fun didLogIn(): List<Result> {
        val client = HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }

        val json = Json {
            ignoreUnknownKeys = true
        }

        var responseContent: Result ?= null

        try {
            runBlocking {
                responseContent =
                    client.post("https://dummyjson.com/auth/login") {
                        contentType(ContentType.Application.Json)
                        setBody(

                                LoginRequest(
                                    username = "kminchelle",
                                    password = "0lelplR",
                                )

                        )
                    }.body()

                // Convert the response to a string


                // Parse the JSON string using kotlinx.serialization

            }
        } catch (e: Exception) {
            println("API Response JSON: ${responseContent?.toString()}")
            println("JSON Parsing Error: ${e.message}")
        }

        return listOf(responseContent!!)
    }
}

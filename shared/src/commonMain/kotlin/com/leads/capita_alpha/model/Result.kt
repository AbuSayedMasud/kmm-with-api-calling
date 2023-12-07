package com.example.ktorimplementing.model

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val id: String,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val token: String
)
package org.sopt.sample.remote

import kotlinx.serialization.Serializable

@Serializable
data class RequestSignUpDTO(
    val email: String,
    val password: String,
    val name: String
)

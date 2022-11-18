package org.sopt.sample.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignupDTO(
    val email : String,
    val password : String,
    val name : String,
)

package org.sopt.sample.remote

import kotlinx.serialization.Serializable

data class ResponseSignUpDTO(
    val status: Int,
    val message: String,
    val result: NewUser
){
    @Serializable
    data class NewUser (
        val id: Int,
        val name: String,
        val profileImage: String?,
        val bio: String?,
        val email: String,
        val password: String
    )
}

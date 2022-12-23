package org.sopt.sample.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseUserDTO(
    val page: Int,
    val per_page: Int,
    val total: Int,
    @SerialName("total_pages")
    val totalPages: Int,
    val data: List<Data>,
    val support: Support,

    ) {
    @Serializable
    data class Data(
        val id: Int,
        val email: String,
        @SerialName("first_name")
        val firstName: String,
        @SerialName("last_name")
        val lastName: String,
        val avatar: String,
    )

    @Serializable
    data class Support(
        val url: String,
        val text: String,
        )
}


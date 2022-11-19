package org.sopt.sample.remote

import kotlinx.serialization.Serializable

@Serializable
data class ResponseUserDTO(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<Data>,
    val support: Support,

    ) {
    @Serializable
    data class Data(
        val id: Int,
        val email: String,
        val first_name: String,
        val last_name: String,
        val avatar: String,
    )

    @Serializable
    data class Support(
        val url: String,
        val text: String,
        )
}


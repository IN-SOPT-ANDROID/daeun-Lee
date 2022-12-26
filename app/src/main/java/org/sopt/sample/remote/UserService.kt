package org.sopt.sample.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("api/users?page=2")
    suspend fun user(): Response<ResponseUserDTO>
}
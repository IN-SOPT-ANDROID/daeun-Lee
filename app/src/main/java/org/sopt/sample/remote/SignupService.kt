package org.sopt.sample.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupService {
    @POST("api/user/signup")
    suspend fun signup(
        @Body requestSignupDTO: RequestSignupDTO
    ): Response<ResponseSignupDTO>
}
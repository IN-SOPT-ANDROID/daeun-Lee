package org.sopt.sample.user

import org.sopt.sample.remote.ResponseUserDTO
import org.sopt.sample.remote.UserServicePool
import retrofit2.Response

class UserRepository {
    suspend fun user(): Response<ResponseUserDTO> =
        UserServicePool.userService.user()
}
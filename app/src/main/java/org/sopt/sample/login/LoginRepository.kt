package org.sopt.sample.login

import org.sopt.sample.remote.RequestLoginDTO
import org.sopt.sample.remote.ServicePool

class LoginRepository {
    suspend fun login(request: RequestLoginDTO) =
        ServicePool.loginService.login(request)
}
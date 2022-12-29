package org.sopt.sample.data.datasource

import org.sopt.sample.remote.RequestLoginDTO
import org.sopt.sample.remote.ResponseLoginDTO
import org.sopt.sample.remote.ServicePool

class LoginDataSource(private val service: ServicePool) {
    suspend fun login(requestLoginDTO: RequestLoginDTO): ResponseLoginDTO =
        service.loginService.login(requestLoginDTO)
}
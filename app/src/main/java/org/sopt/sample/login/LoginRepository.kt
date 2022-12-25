package org.sopt.sample.login

import org.sopt.sample.remote.RequestLoginDTO
import org.sopt.sample.remote.ServicePool
import timber.log.Timber

class LoginRepository {
    suspend fun login(email: String, password: String) : Boolean=
        kotlin.runCatching {
            ServicePool.loginService.login(RequestLoginDTO(email, password))
        }.fold({
            Timber.d("성공")
            true
        }, {
            Timber.d("실패")
            false
        })
}
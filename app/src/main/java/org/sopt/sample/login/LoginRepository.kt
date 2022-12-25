package org.sopt.sample.login

import org.sopt.sample.remote.RequestLoginDTO
import org.sopt.sample.remote.ServicePool
import timber.log.Timber

class LoginRepository {
    suspend fun login(email: String, password: String) : Boolean=
        kotlin.runCatching {
            ServicePool.loginService.login(RequestLoginDTO(email, password))
        }.fold({
            Timber.d("로그인 서버통신 성공")
            true
        }, {
            Timber.d("로그인 서버통신 실패")
            false
        })
}
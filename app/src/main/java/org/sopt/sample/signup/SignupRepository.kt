package org.sopt.sample.signup

import org.sopt.sample.remote.RequestSignupDTO
import org.sopt.sample.remote.ServicePool
import timber.log.Timber

class SignupRepository {
    suspend fun signup(email: String, password: String, name: String) : Boolean=
        kotlin.runCatching {
            ServicePool.signupService.signup(RequestSignupDTO(email, password, name))
        }.fold({
            Timber.d("회원가입 서버통신 성공")
            true
        }, {
            Timber.d("회원가입 서버통신 실패")
            false
        })
}
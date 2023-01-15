package org.sopt.sample.data.repositoryImpl

import org.sopt.sample.data.datasource.LoginDataSource
import org.sopt.sample.domain.LoginRepository
import org.sopt.sample.remote.RequestLoginDTO
import timber.log.Timber

class LoginRepositoryImpl(
    private val loginDataSource: LoginDataSource
): LoginRepository {
    override suspend fun login(email: String, password: String) : Boolean =
        kotlin.runCatching {
           loginDataSource.login(RequestLoginDTO(email, password))
        }.fold({
            Timber.d("로그인 서버통신 성공")
            true
        }, {
            Timber.d("로그인 서버통신 실패")
            false
        })
}
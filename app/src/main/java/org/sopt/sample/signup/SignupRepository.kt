package org.sopt.sample.signup

import org.sopt.sample.remote.RequestSignupDTO
import org.sopt.sample.remote.ServicePool

class SignupRepository {
    suspend fun signup(request: RequestSignupDTO) =
        ServicePool.signupService.signup(request)
}
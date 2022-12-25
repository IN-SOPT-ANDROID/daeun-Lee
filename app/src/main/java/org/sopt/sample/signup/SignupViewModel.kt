package org.sopt.sample.signup

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import org.sopt.sample.remote.RequestSignupDTO
import org.sopt.sample.remote.ResponseSignupDTO
import timber.log.Timber

class SignupViewModel(private val repository: SignupRepository): ViewModel() {
    private val _signupResult: MutableLiveData<ResponseSignupDTO> = MutableLiveData()
    val signupResult: LiveData<ResponseSignupDTO>
        get() = _signupResult

    val inputEmail = MutableLiveData<String>()
    val inputPw = MutableLiveData<String>()

    val isvalidEmail: LiveData<Boolean>
        get() = Transformations.map(inputEmail)
        { email -> email?.matches(EMAIL_PATTERN.toRegex()) }
    val isvalidPw: LiveData<Boolean>
        get() = Transformations.map(inputPw) { pw -> pw?.matches(PASSWORD_PATTERN.toRegex()) }

    fun signup(requestSignupDTO: RequestSignupDTO) {
        viewModelScope.launch {
            val response = repository.signup(requestSignupDTO)

            if (response.isSuccessful) {
                _signupResult.postValue(response.body())
                Timber.d("회원가입 서버 통신 성공")
            } else {
                Timber.d("회원가입 서버 통신 실패")
            }
        }
    }

    companion object {
        private const val EMAIL_PATTERN = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,10}\$"
        private const val PASSWORD_PATTERN =
            "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&.])[A-Za-z[0-9]\$@\$!%*#?&.]{6,12}\$"
    }


}
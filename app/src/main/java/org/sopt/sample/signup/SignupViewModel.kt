package org.sopt.sample.signup

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class SignupViewModel(private val repository: SignupRepository) : ViewModel() {
    private val _signupResult: MutableLiveData<Boolean> = MutableLiveData()
    val signupResult: LiveData<Boolean>
        get() = _signupResult

    val inputEmail = MutableLiveData<String>()
    val inputPw = MutableLiveData<String>()
    val inputName = MutableLiveData<String>()

    val isvalidEmail: LiveData<Boolean>
        get() = Transformations.map(inputEmail)
        { email -> email?.matches(EMAIL_PATTERN.toRegex()) }
    val isvalidPw: LiveData<Boolean>
        get() = Transformations.map(inputPw) { pw -> pw?.matches(PASSWORD_PATTERN.toRegex()) }

    fun signup() {
        viewModelScope.launch {
            val isSuccesful = repository.signup(
                inputEmail.value.toString(), inputPw.value.toString(),
                inputName.value.toString()
            )
            if (isSuccesful)
                _signupResult.value = isSuccesful
        }
    }

    companion object {
        private const val EMAIL_PATTERN = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,10}\$"
        private const val PASSWORD_PATTERN =
            "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&.])[A-Za-z[0-9]\$@\$!%*#?&.]{6,12}\$"
    }


}
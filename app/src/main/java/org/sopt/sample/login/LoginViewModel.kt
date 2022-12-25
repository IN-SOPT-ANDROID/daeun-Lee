package org.sopt.sample.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.sample.remote.RequestLoginDTO
import org.sopt.sample.remote.ResponseLoginDTO
import timber.log.Timber

class LoginViewModel (private val repository: LoginRepository): ViewModel() {
    private val _loginResult: MutableLiveData<ResponseLoginDTO> = MutableLiveData()
    val loginResult: LiveData<ResponseLoginDTO>
        get() = _loginResult

    fun login(requestLoginDTO: RequestLoginDTO) {
        viewModelScope.launch {
            val response = repository.login(requestLoginDTO)

            if (response.isSuccessful) {
                _loginResult.postValue(response.body())
                Timber.d("로그인 서버통신 성공")
            }
            else{
                Timber.d("로그인 서버통신 실패")
            }
        }
    }
}
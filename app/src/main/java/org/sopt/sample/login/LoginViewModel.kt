package org.sopt.sample.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
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
                Timber.d(response.body().toString())
            }
            else{
                Timber.d(response.body().toString())
            }
        }
    }
}
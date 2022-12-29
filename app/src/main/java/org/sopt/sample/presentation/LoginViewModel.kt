package org.sopt.sample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.sample.data.repositoryImpl.LoginRepositoryImpl

class LoginViewModel (private val repository: LoginRepositoryImpl): ViewModel() {
    private val _loginResult: MutableLiveData<Boolean> = MutableLiveData()
    val loginResult: LiveData<Boolean>
        get() = _loginResult
    val inputEmail = MutableLiveData<String>()
    val inputPw = MutableLiveData<String>()

    fun login() {
        viewModelScope.launch {
            val isSuccesful = repository.login(inputEmail.value.toString(), inputPw.value.toString())
            if(isSuccesful)
                _loginResult.value = isSuccesful
        }
    }
}
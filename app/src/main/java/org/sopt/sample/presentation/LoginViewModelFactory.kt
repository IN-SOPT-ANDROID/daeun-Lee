package org.sopt.sample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.sample.data.repositoryImpl.LoginRepositoryImpl

class LoginViewModelFactory(private val loginRepository: LoginRepositoryImpl):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(loginRepository) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}

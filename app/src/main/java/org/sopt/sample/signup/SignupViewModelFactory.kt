package org.sopt.sample.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignupViewModelFactory (private val signupRepository: SignupRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SignupViewModel::class.java)) {
            SignupViewModel(signupRepository) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}
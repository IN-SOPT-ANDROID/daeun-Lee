package org.sopt.sample.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sample.remote.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: ViewModel() {
    private val _loginResult: MutableLiveData<ResponseLoginDTO> = MutableLiveData()
    val loginResult: LiveData<ResponseLoginDTO>
        get() = _loginResult
    private val loginService = ServicePool.loginService
    fun login(email: String, password: String) {
        loginService.login(
            RequestLoginDTO(email, password)
        ).enqueue(object : Callback<ResponseLoginDTO> {
            override fun onResponse(
                call: Call<ResponseLoginDTO>,
                response: Response<ResponseLoginDTO>
            ) {
                Log.d("로그인 성공", "${response.body()}")
                _loginResult.value = response.body()
            }

            override fun onFailure(call: Call<ResponseLoginDTO>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
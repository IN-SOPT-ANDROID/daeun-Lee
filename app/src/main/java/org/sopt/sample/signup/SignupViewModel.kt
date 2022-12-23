package org.sopt.sample.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import org.sopt.sample.remote.RequestSignupDTO
import org.sopt.sample.remote.ResponseSignupDTO
import org.sopt.sample.remote.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class SignupViewModel: ViewModel() {
    private val _signupResult: MutableLiveData<ResponseSignupDTO> = MutableLiveData()
    val signupResult: LiveData<ResponseSignupDTO>
        get() = _signupResult

    val inputEmail = MutableLiveData<String>()
    val inputPw = MutableLiveData<String>()
    val isvalidEmail : LiveData<Boolean> = Transformations.map(inputEmail){emailCheck(it)}
    val isvalidPw : LiveData<Boolean> = Transformations.map(inputPw){pwCheck(it)}

    private val signupService = ServicePool.signupService
    fun signup(email: String, password: String, name: String){
        signupService.signup(
            RequestSignupDTO(email, password, name)
        ).enqueue(object : Callback<ResponseSignupDTO>{
            override fun onResponse(
                call: Call<ResponseSignupDTO>,
                response: Response<ResponseSignupDTO>
            ) {
                _signupResult.value = response.body()
                Log.d("회원가입 성공", "${response.body()}")
            }

            override fun onFailure(call: Call<ResponseSignupDTO>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
    private fun emailCheck(email: String):Boolean{
        val emailPattern = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,10}$"
        val pattern = Pattern.compile(emailPattern)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    private fun pwCheck(pw: String):Boolean{
        val pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{6,12}$"
        val pattern = Pattern.compile(pwPattern)
        val matcher = pattern.matcher(pw)
        return matcher.matches()
    }

}
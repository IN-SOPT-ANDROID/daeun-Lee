package org.sopt.sample.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sample.remote.ResponseUserDTO
import org.sopt.sample.remote.UserServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class UserViewModel : ViewModel() {
    private val _userInfo = MutableLiveData<List<ResponseUserDTO.Data>>()
    val userInfo: LiveData<List<ResponseUserDTO.Data>>
        get() = _userInfo

    private val userService = UserServicePool.userService

    private var items : List<ResponseUserDTO.Data> = emptyList()

    init{
            userService.user().enqueue(object : Callback<ResponseUserDTO> {
            override fun onResponse(
                call: Call<ResponseUserDTO>,
                response: Response<ResponseUserDTO>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        items = it.data
                        _userInfo.value = items
                    }
                }
            }
            override fun onFailure(call: Call<ResponseUserDTO>, t: Throwable) {
                Timber.d("실패실패")
            }
        })
    }
}
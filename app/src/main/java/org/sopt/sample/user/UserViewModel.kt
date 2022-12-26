package org.sopt.sample.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.sample.remote.ResponseUserDTO

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    private val _userInfo = MutableLiveData<List<ResponseUserDTO.Data>>()
    val userInfo: LiveData<List<ResponseUserDTO.Data>>
        get() = _userInfo

    private var items : List<ResponseUserDTO.Data> = emptyList()

    fun fatchUser() {
        viewModelScope.launch {
            items = repository.user().body()!!.data
            _userInfo.value = items
        }
    }
}

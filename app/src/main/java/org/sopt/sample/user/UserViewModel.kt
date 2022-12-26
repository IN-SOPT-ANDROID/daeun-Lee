package org.sopt.sample.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sample.R
import org.sopt.sample.data.UserData

class UserViewModel : ViewModel() {
    private val _userInfo = MutableLiveData<ArrayList<UserData>>()
    val userInfo: LiveData<ArrayList<UserData>>
        get() = _userInfo

    private var items = ArrayList<UserData>()

    init{
        items = arrayListOf(
            UserData(
                image =  R.drawable.github,
                name = "다은이",
                email = "eldms@0403",
                viewType = 0),
            UserData(
                image =  R.drawable.ic_launcher_background,
                name = "지현이",
                email = "eldms@0403",
                viewType = 0),
            UserData(
                image =  R.drawable.github,
                name = "주니이",
                email = "eldms@0403",
                viewType = 0)
        )
        _userInfo.value = items
    }

}
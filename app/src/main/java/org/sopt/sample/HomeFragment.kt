package org.sopt.sample

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.adapter.rvAdapter
import org.sopt.sample.base.BindingFragment
import org.sopt.sample.databinding.FragmentHomeBinding
import org.sopt.sample.remote.ResponseUserDTO
import org.sopt.sample.remote.UserServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
        get() = requireNotNull(_binding)
    private val userService = UserServicePool.userService

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        val adapter = rvAdapter(requireContext())
        binding.rvRepos.adapter = adapter
        userService.user().enqueue(object : Callback<ResponseUserDTO> {
            override fun onResponse(
                call: Call<ResponseUserDTO>,
                response: Response<ResponseUserDTO>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        Timber.d("${response.body()}")
                        adapter.setRepoList(it.data)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseUserDTO>, t: Throwable) {
                Snackbar.make(binding.root, "서버통신 실패", Snackbar.LENGTH_LONG).show()
            }
        })
    }
}
package org.sopt.sample

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.sopt.sample.adapter.rvAdapter
import org.sopt.sample.base.BindingFragment
import org.sopt.sample.databinding.FragmentHomeBinding
import org.sopt.sample.remote.UserServicePool
import org.sopt.sample.user.UserViewModel
import timber.log.Timber

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val userService = UserServicePool.userService
    private lateinit var viewModel: UserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = rvAdapter(requireContext())
        binding.rvRepos.adapter = adapter

        viewModel.userInfo.observe(viewLifecycleOwner, Observer {
            adapter.setRepoList(it)
        })

//        userService.user().enqueue(object : Callback<ResponseUserDTO> {
//            override fun onResponse(
//                call: Call<ResponseUserDTO>,
//                response: Response<ResponseUserDTO>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        Timber.d("${response.body()}")
//                        adapter.setRepoList(it.data)
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseUserDTO>, t: Throwable) {
//                Snackbar.make(binding.root, "서버통신 실패", Snackbar.LENGTH_LONG).show()
//            }
//        })
    }
}
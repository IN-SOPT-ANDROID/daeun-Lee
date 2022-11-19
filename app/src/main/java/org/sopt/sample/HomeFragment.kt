package org.sopt.sample

import org.sopt.sample.adapter.rvAdapter
import org.sopt.sample.databinding.FragmentHomeBinding
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.remote.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment: Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding : FragmentHomeBinding
        get() = requireNotNull(_binding)
    private val userService = UserServicePool.userService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = rvAdapter(requireContext())
        binding.rvRepos.adapter = adapter
        userService.user().enqueue(object : Callback<ResponseUserDTO> {
            override fun onResponse(
                call: Call<ResponseUserDTO>,
                response: Response<ResponseUserDTO>
            ) {
                Log.d("유저 정보", "${response.body()}")
                if (response.isSuccessful) {
                    response.body()?.let {
                        adapter.setRepoList(it.data)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseUserDTO>, t: Throwable) {
                Snackbar.make(binding.root, "서버통신 실패", Snackbar.LENGTH_LONG).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package org.sopt.sample

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.sopt.sample.adapter.rvAdapter
import org.sopt.sample.base.BindingFragment
import org.sopt.sample.databinding.FragmentHomeBinding
import org.sopt.sample.user.UserRepository
import org.sopt.sample.user.UserViewModel
import org.sopt.sample.user.UserViewModelFactory

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var viewModel: UserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, UserViewModelFactory(UserRepository()))
            .get(UserViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = rvAdapter(requireContext())
        binding.rvRepos.adapter = adapter

        viewModel.fatchUser()

        viewModel.userInfo.observe(viewLifecycleOwner, Observer {
            adapter.setRepoList(it)
        })
    }
}
package org.sopt.sample

import org.sopt.sample.adapter.rvAdapter
import org.sopt.sample.data.Repo
import org.sopt.sample.databinding.FragmentHomeBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment

class HomeFragment: Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding : FragmentHomeBinding
        get() = requireNotNull(_binding)


    private val mockRepoList = listOf<Repo> (
        Repo(
            name = "다니의 레포지터리",
            viewType = 1,
            author = "google",
            image = R.drawable.github
        ),
        Repo(
            image = R.drawable.github,
            name = "Android",
            author = "Google",
            viewType = 0
        ),
        Repo(
            image = R.drawable.github,
            name = "Android",
            author = "Google",
            viewType = 0
        ),
        Repo(
            image = R.drawable.github,
            name = "Android",
            author = "Google",
            viewType = 0
        ),
        Repo(
            image = R.drawable.github,
            name = "Android",
            author = "Google",
            viewType = 0
        ),
        Repo(
            image = R.drawable.github,
            name = "Android",
            author = "Google",
            viewType = 0
        ),
        Repo(
            image = R.drawable.github,
            name = "Android",
            author = "Google",
            viewType = 0
        ),
        Repo(
            image = R.drawable.github,
            name = "Android",
            author = "Google",
            viewType = 0
        ),
        Repo(
            image = R.drawable.github,
            name = "Android",
            author = "Google",
            viewType = 0
        ),
        Repo(
            image = R.drawable.github,
            name = "Android",
            author = "Google",
            viewType = 0
        )
    )
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
        adapter.setRepoList(mockRepoList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
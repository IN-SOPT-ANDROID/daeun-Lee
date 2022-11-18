package org.sopt.sample.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import org.sopt.sample.databinding.LayoutGithubRepoBinding
import org.sopt.sample.remote.ResponseUserDTO

class RepoViewHolder(
    private val binding: LayoutGithubRepoBinding
): RecyclerView.ViewHolder(binding.root){
    fun onBind(data: ResponseUserDTO.Data){
        binding.imgGithub.load(data.avatar)
        binding.txtGithubName.setText(data.first_name)
        binding.txtGithubAuthor.setText(data.email)
    }

}
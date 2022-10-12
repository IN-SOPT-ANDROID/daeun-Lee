package org.sopt.sample.adapter

import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.data.Repo
import org.sopt.sample.databinding.LayoutGithubRepoBinding

class RepoViewHolder(
    private val binding: LayoutGithubRepoBinding
): RecyclerView.ViewHolder(binding.root){
    fun onBind(data: Repo){
        binding.imgGithub.setImageDrawable(binding.root.context.getDrawable(data.image))
        binding.txtGithubName.setText(data.name)
        binding.txtGithubAuthor.setText(data.author)
    }

}
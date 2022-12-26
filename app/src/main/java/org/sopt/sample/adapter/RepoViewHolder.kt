package org.sopt.sample.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import org.sopt.sample.data.UserData
import org.sopt.sample.databinding.ItemUserInfoBinding
import org.sopt.sample.remote.ResponseUserDTO

class RepoViewHolder(
    private val binding: ItemUserInfoBinding
): RecyclerView.ViewHolder(binding.root){
    fun onBind(data: UserData){
        binding.data = data
    }
}
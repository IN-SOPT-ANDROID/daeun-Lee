package org.sopt.sample.adapter

import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.data.Repo
import org.sopt.sample.databinding.LayoutHeaderBinding

class TitleViewHolder (
    private val binding: LayoutHeaderBinding
): RecyclerView.ViewHolder(binding.root){
    fun onBind(data: Repo){
        binding.title.setText(data.name)
    }
}
package org.sopt.sample.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.databinding.LayoutGithubRepoBinding
import org.sopt.sample.databinding.LayoutHeaderBinding
import org.sopt.sample.remote.ResponseUserDTO

class rvAdapter(context : Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater by lazy {LayoutInflater.from(context)}
    private var repoList: List<ResponseUserDTO.Data> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            REPO_TYPE ->{
                val binding = LayoutGithubRepoBinding.inflate(inflater, parent,false)
                RepoViewHolder(binding)
            }
            HEADER_TYPE ->{
                val binding = LayoutHeaderBinding.inflate(inflater, parent,false)
                TitleViewHolder(binding)
            }
            else -> throw RuntimeException("Error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is RepoViewHolder ->
            holder.onBind(repoList[position])
        }
    }

    override fun getItemCount(): Int = repoList.size

    fun setRepoList(repoList: List<ResponseUserDTO.Data>){
        this.repoList = repoList.toList()
        notifyDataSetChanged()
    }

    companion object {
        const val REPO_TYPE = 0 // repo view
        const val HEADER_TYPE = 1 // title view
    }
}

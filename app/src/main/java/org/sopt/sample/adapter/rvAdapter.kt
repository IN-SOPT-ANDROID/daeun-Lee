package org.sopt.sample.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.data.Repo
import org.sopt.sample.data.Repo.Companion.HEADER_TYPE
import org.sopt.sample.data.Repo.Companion.REPO_TYPE
import org.sopt.sample.databinding.LayoutGithubRepoBinding
import org.sopt.sample.databinding.LayoutHeaderBinding

class rvAdapter(context : Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater by lazy {LayoutInflater.from(context)}
    private var repoList: List<Repo> = emptyList()

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
        val currentItem = repoList[position]

        when(currentItem.viewType){
            REPO_TYPE -> (holder as RepoViewHolder).onBind(currentItem)
            HEADER_TYPE -> (holder as TitleViewHolder).onBind(currentItem)
        }
    }

    override fun getItemCount(): Int = repoList.size

    override fun getItemViewType(position: Int): Int {
        return repoList[position].viewType
    }

    fun setRepoList(repoList: List<Repo>){
        this.repoList = repoList.toList()
        notifyDataSetChanged()
    }

}
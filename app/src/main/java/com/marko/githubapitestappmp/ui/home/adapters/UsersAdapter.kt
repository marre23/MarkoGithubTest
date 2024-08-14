package com.marko.githubapitestappmp.ui.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marko.domain.models.UserRepoItem
import com.marko.githubapitestappmp.databinding.ItemUserBinding

class UsersAdapter(var listener: UserListener? = null) :
    RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    private var listOfUsers: List<UserRepoItem>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<UserRepoItem>) {
        listOfUsers = data
        notifyDataSetChanged()
    }

    inner class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pos: Int) {
            val user = listOfUsers?.get(pos)
            with(binding) {
                user?.let {
                    textViewUserName.text = user.name
                    textViewIssues.text = "${user.openIssuesCount} opened issues"
                    root.setOnClickListener {
                        listener?.onUserClick(user.name)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listOfUsers?.size ?: 0

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(position)
    }
}

package com.example.assignment4_011224.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment4_011224.databinding.UserItemBinding
import com.example.assignment4_011224.model.User
import androidx.constraintlayout.widget.ConstraintLayout

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var userList = emptyList<User>()

    inner class UserViewHolder(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.name.text = user.name
            binding.age.text = user.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount() = userList.size

    fun submitList(list: List<User>) {
        userList = list
        notifyDataSetChanged()
    }
}

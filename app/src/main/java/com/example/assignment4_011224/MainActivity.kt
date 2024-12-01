package com.example.assignment4_011224

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment4_011224.adapter.UserAdapter
import com.example.assignment4_011224.data.UserDatabase
import com.example.assignment4_011224.repository.UserRepository
import com.example.assignment4_011224.viewmodel.UserViewModel
import com.example.assignment4_011224.viewmodel.UserViewModelFactory
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(UserRepository(UserDatabase.getDatabase(this).userDao()))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = UserAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        userViewModel.allUsers.observe(this) { users ->
            adapter.submitList(users)
        }
    }
}

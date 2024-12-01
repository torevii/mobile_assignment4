package com.example.assignment4_011224.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment4_011224.model.Post
import com.example.assignment4_011224.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class PostViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    fun fetchPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.instance
                    .create(com.example.assignment4_011224.network.ApiService::class.java)
                    .getPosts()
                    .awaitResponse()

                if (response.isSuccessful) {
                    _posts.postValue(response.body())
                }
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}

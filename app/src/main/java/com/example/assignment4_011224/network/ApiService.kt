package com.example.assignment4_011224.network

import retrofit2.http.GET
import retrofit2.Call
import com.example.assignment4_011224.model.Post

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}

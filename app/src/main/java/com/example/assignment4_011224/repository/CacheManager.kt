package com.example.assignment4_011224.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.assignment4_011224.model.Post

class CacheManager(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("api_cache", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun savePosts(posts: List<Post>) {
        val json = gson.toJson(posts)
        sharedPreferences.edit().putString("posts", json).apply()
    }

    fun getPosts(): List<Post>? {
        val json = sharedPreferences.getString("posts", null)
        val type = object : TypeToken<List<Post>>() {}.type
        return gson.fromJson(json, type)
    }
}

package com.example.assignment4_011224.repository

import androidx.lifecycle.LiveData
import com.example.assignment4_011224.data.UserDao
import com.example.assignment4_011224.model.User

class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun update(user: User) {
        userDao.update(user)
    }

    suspend fun delete(user: User) {
        userDao.delete(user)
    }
}

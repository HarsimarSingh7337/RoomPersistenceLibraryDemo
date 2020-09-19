package com.example.roomlibraryexample.repository

import androidx.lifecycle.LiveData
import com.example.roomlibraryexample.roomlibrary.UserDao
import com.example.roomlibraryexample.roomlibrary.UserEntity

class UserRepository(private val userDao: UserDao ) {

    suspend fun insert(user: UserEntity){
        userDao.addUser(user)
    }
}
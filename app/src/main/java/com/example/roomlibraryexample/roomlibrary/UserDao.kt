package com.example.roomlibraryexample.roomlibrary

import androidx.room.*

@Dao
interface UserDao {

    @Query("Select * from UserEntity")
    fun getAllUser(): MutableList<UserEntity>

    @Insert
    suspend fun addUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Query("Select * from userEntity where uid Like :id ")
    fun searchUserById(id: Int): UserEntity
}
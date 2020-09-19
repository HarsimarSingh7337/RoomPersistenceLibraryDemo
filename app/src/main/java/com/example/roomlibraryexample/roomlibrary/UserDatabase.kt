package com.example.roomlibraryexample.roomlibrary

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UserEntity::class] ,
    version = 1
)
abstract class UserDatabase: RoomDatabase(){

    abstract fun getUserDao(): UserDao

    companion object{

         fun get(context: Context): UserDatabase{
            return Room.databaseBuilder(context, UserDatabase::class.java, "UserDatabase").build()
        }
    }
}
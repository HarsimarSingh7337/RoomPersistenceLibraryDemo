package com.example.roomlibraryexample.roomlibrary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(

    @ColumnInfo
    val firstName: String?,

    @ColumnInfo
    val lastName: String?,

    @ColumnInfo
    val city: String?,

    @ColumnInfo
    val mobile: String?

){
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

}
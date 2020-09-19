package com.example.roomlibraryexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomlibraryexample.repository.UserRepository
import com.example.roomlibraryexample.roomlibrary.UserDatabase
import com.example.roomlibraryexample.roomlibrary.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.

    init {
        val wordsDao = UserDatabase.get(application).getUserDao()
        repository = UserRepository(wordsDao)
    }


    fun insert(user: UserEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }


}
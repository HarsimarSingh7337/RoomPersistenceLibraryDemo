package com.example.roomlibraryexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.roomlibraryexample.databinding.ActivityMainBinding
import com.example.roomlibraryexample.repository.UserRepository
import com.example.roomlibraryexample.roomlibrary.UserDatabase
import com.example.roomlibraryexample.roomlibrary.UserEntity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var repository: UserRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
        val v: View = binding.root;
        setContentView(v)

    }

    fun submitData(v: View){

        val firstName = binding.firstname.text.toString()
        val lastName = binding.lastname.text.toString()
        val city = binding.city.text.toString()
        val mobile = binding.mobile.text.toString()


        if(firstName.isEmpty() || lastName.isEmpty() || city.isEmpty() || mobile.isEmpty()){
            Toast.makeText(applicationContext,"Invalid field detected",Toast.LENGTH_SHORT).show()
        }
        else{
            val user = UserEntity(firstName,lastName,city,mobile)

            val scope = CoroutineScope(Dispatchers.IO)
            scope.launch {
                UserDatabase.get(applicationContext).getUserDao().addUser(user)
            }
            Toast.makeText(applicationContext,"User Added",Toast.LENGTH_SHORT).show()
        }
    }

    fun searchUser(v:View){

        binding.firstname.setText("")
        binding.lastname.setText("")
        binding.city.setText("")
        binding.mobile.setText("")


        var list = mutableListOf<UserEntity>()
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            async {
                list = UserDatabase.get(applicationContext).getUserDao().getAllUser()
            }.await()

            Log.e("User: ",list.toString())
        }
    }
}
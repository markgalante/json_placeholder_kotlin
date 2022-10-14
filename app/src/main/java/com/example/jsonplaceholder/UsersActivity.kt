package com.example.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.jsonplaceholder.helpers.QueryUser
import com.example.jsonplaceholder.helpers.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        val userListView = findViewById<ListView>(R.id.user_list_view)
        title = "Users"

        val callback = object: Callback<List<User>>{
            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                val users = response.body()
                val listOfUsers = mutableListOf<String>()
                if(users !== null){
                    for (user in users){
                        listOfUsers.add(user.name)
                    }
                }
                val adapter = ArrayAdapter(
                    this@UsersActivity,
                    android.R.layout.simple_list_item_1,
                    listOfUsers
                )
                userListView.adapter = adapter
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                println("error: $call")
                println("t: ${t.localizedMessage}")
            }

        }

        val user = QueryUser()
        user.getUsers(callback)

    }
}
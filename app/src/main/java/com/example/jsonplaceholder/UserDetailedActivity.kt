package com.example.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholder.helpers.QueryUser
import com.example.jsonplaceholder.helpers.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDetailedActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detailed)

        newRecyclerView = findViewById(R.id.user_recycler_list_view)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<User>()

        val callback = object:Callback<ArrayList<User>>{
            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
                val users = response.body()
                if(users !== null){
                    for(user in users){
                        newArrayList.add(user)
                    }
                }
                newRecyclerView.adapter = UserAdapter(newArrayList)
            }
            override fun onFailure(
                call: Call<ArrayList<User>>,
                t: Throwable
            ) {
                Toast.makeText(
                    this@UserDetailedActivity,
                    "Ooops - something went wrong",
                    Toast.LENGTH_LONG,
                    ).show()
            }
        }

        val user = QueryUser()
        user.getUsersList(callback)
    }
}
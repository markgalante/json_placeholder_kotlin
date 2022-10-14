package com.example.jsonplaceholder.helpers

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

interface UsersService {
    @GET("/users")
    fun getUsers(): Call<List<User>>
}

data class User (
    val id: Byte,
    val name: String,
    val username: String,
    val email: String,
    )

class QueryUser{
    private val service: UsersService
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(UsersService::class.java)
    }
    fun getUsers(callback: Callback<List<User>>){
        val call = service.getUsers()
        call.enqueue(callback)
    }
}
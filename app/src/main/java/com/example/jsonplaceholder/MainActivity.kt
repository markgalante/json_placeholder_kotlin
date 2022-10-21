package com.example.jsonplaceholder

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postsBtn = findViewById<Button>(R.id.btn_posts)
        val albumsBtn = findViewById<Button>(R.id.btn_albums)
        val usersBtn = findViewById<Button>(R.id.btn_users)

        postsBtn.setOnClickListener {
            val intent = Intent(
                applicationContext,
                PostsActivity::class.java
            )
            startActivity(intent)
        }
        albumsBtn.setOnClickListener {
            val intent = Intent (
                applicationContext,
                AlbumsActivity::class.java
            )
            startActivity(intent)
        }
        usersBtn.setOnClickListener {
            val intent = Intent (
                applicationContext,
                UsersActivity::class.java
            )
            startActivity(intent)
        }
    }
}
package com.example.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AlbumsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)
        title = "Albums"
    }
}
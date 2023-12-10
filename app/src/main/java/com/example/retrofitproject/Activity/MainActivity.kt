package com.example.retrofitproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var Binding: ActivityMainBinding
    var id: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        Binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(Binding.root)
        intview()
    }

    private fun intview() {
        if(intent!== null)
        {
            var id = intent.getStringExtra("id").toString()
            var title = intent.getStringExtra("title").toString()
            var albumId = intent.getStringExtra("albumId").toString()


            Binding.txtId.text=id
            Binding.txtuserId.text=albumId
            Binding.txtTitle.text=title

        }
    }
}
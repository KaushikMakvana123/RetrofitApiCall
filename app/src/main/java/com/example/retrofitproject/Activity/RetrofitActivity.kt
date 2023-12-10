package com.example.retrofitproject.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitproject.Interface.MyInterface
import com.example.retrofitproject.Object.RetrofitHelper
import com.example.retrofitproject.Adapter.RetrofitAdapter
import com.example.retrofitproject.databinding.ActivityRetrofitBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RetrofitActivity : AppCompatActivity() {
    lateinit var binding: ActivityRetrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {


        binding.btnClick.setOnClickListener {

            val Procuteapi = RetrofitHelper.getInstance().create(MyInterface::class.java)
            // launching a new coroutine
            GlobalScope.launch {
                val result = Procuteapi.getProduct()
                if (result != null) {
                    // Checking the results
                    Log.e("TAG", "initview data: " + result)
                }


                runOnUiThread {


                    var adapter = RetrofitAdapter(
                        this@RetrofitActivity,
                        result,
                        onclick = { id, title, albumId ->
                            val i = Intent(this@RetrofitActivity, MainActivity::class.java)
                            i.putExtra("id", id)
                            i.putExtra("title", title)
                            i.putExtra("albumId", albumId)

                            startActivity(i)


                        })

                    var manager =
                        LinearLayoutManager(this@RetrofitActivity, RecyclerView.VERTICAL, false)
                    binding.rcv.adapter = adapter
                    binding.rcv.layoutManager = manager


                }


            }

        }

    }
}


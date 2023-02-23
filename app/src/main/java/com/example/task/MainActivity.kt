package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task.adapter.HorizontalAdapter
import com.example.task.adapter.VerticalAdapter
import com.example.task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter1 : HorizontalAdapter
    private lateinit var adapter2 : VerticalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView1()
        setUpRecyclerView2()

    }

    private fun setUpRecyclerView1(){

        binding.recycler1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter1 = HorizontalAdapter(Tools.list1)
        binding.recycler1.adapter = adapter1

    }

    private fun setUpRecyclerView2(){

        binding.recycler2.layoutManager = LinearLayoutManager(this)
        adapter2 = VerticalAdapter(Tools.list2)
        binding.recycler2.adapter = adapter2

    }
}
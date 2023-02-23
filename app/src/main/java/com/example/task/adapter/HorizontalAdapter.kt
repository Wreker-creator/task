package com.example.task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task.databinding.Item1Binding
import com.example.task.model.Model1

class HorizontalAdapter(private val list : List<Model1>) : RecyclerView.Adapter<HorizontalAdapter.MyViewHolder>(){

    inner class MyViewHolder(val binding : Item1Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(Item1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val current = list[position]

        holder.binding.ttvViews.text = "${current.views} views"
        holder.binding.ttvTitle.text = current.title.toString()

    }

    override fun getItemCount(): Int {
        return list.size
    }

}
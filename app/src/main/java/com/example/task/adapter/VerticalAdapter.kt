package com.example.task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task.databinding.Item2Binding
import com.example.task.model.Model2

class VerticalAdapter(private val list : List<Model2>) : RecyclerView.Adapter<VerticalAdapter.MyViewHolder>(){

    inner class MyViewHolder(val binding : Item2Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(Item2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val current = list[position]

        holder.binding.apply {

            ttvTime.text = current.uploadDate
            ttvViews.text = "${current.views} views"
            ttvTitle.text = current.title
            ttvChannelName.text = current.channelName
            //imgChannelIcon and imgThumbnail
        }

    }

    override fun getItemCount(): Int{
        return list.size
    }

}
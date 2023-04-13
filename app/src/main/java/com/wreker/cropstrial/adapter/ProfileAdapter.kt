package com.wreker.cropstrial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.wreker.cropstrial.databinding.CropItemBinding
import com.wreker.cropstrial.databinding.YourCropItemBinding
import com.wreker.cropstrial.model.Crops

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.MyViewHolder>(){

    inner class MyViewHolder(val binding : YourCropItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object  : DiffUtil.ItemCallback<Crops>(){
        override fun areItemsTheSame(oldItem: Crops, newItem: Crops): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Crops, newItem: Crops): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(YourCropItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = differ.currentList[position]
        holder.binding.cropName.text = currentItem.cropName
        holder.binding.cropPrice.text = currentItem.price.toString() + "Rs/Kg"

    }


}
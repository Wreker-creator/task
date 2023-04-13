
package com.wreker.cropstrial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.wreker.cropstrial.R
import com.wreker.cropstrial.databinding.CropItemBinding
import com.wreker.cropstrial.fragment.AllCropsFragmentDirections
import com.wreker.cropstrial.model.Crops

class RecyclerAdapter() : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private val differCallBack = object  : DiffUtil.ItemCallback<Crops>(){
        override fun areItemsTheSame(oldItem: Crops, newItem: Crops): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Crops, newItem: Crops): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallBack)

    inner class MyViewHolder(val binding : CropItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CropItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentCrop = differ.currentList[position]
        holder.binding.apply {
            cropName.text = currentCrop.cropName.toString()
            cropPrice.text = currentCrop.price.toString() + "Rs/Kg"
        }

        holder.binding.root.setOnClickListener {

            val directions = AllCropsFragmentDirections.actionAllCropsFragmentToCropDetailsFragment(currentCrop)
            it.findNavController().navigate(directions)

        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}
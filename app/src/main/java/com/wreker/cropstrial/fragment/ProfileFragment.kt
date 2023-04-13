package com.wreker.cropstrial.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.wreker.cropstrial.MainActivity
import com.wreker.cropstrial.R
import com.wreker.cropstrial.adapter.ProfileAdapter
import com.wreker.cropstrial.databinding.FragmentProfileBinding
import com.wreker.cropstrial.viewModel.MyViewModel


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding : FragmentProfileBinding?=null
    private val binding get() = _binding!!
    private lateinit var adapter : ProfileAdapter

    private lateinit var viewModel : MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ProfileAdapter()
        viewModel = (activity as MainActivity).viewModel1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        _binding = FragmentProfileBinding.bind(view)
        if(adapter.differ.currentList.size == 0){
            binding.header.text = ""
            binding.btnSellYourProduce.text = "Add Crop To Sell?"
        }else{
            binding.header.text = "Your Produce -"
            binding.btnSellYourProduce.text = "Add Another Crop"
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.displaySelectedCrops().observe(viewLifecycleOwner){
            adapter.differ.submitList(it)
        }

        binding.btnSellYourProduce.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_sellYourCropsFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
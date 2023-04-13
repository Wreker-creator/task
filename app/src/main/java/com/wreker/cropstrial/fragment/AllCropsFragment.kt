package com.wreker.cropstrial.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wreker.cropstrial.MainActivity
import com.wreker.cropstrial.R
import com.wreker.cropstrial.adapter.RecyclerAdapter
import com.wreker.cropstrial.databinding.FragmentAllCropsBinding


class AllCropsFragment : Fragment(R.layout.fragment_all_crops){

    private var _binding : FragmentAllCropsBinding?=null
    private val binding get() = _binding!!

    private lateinit var adapter : RecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentAllCropsBinding.bind(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter

        val viewModel = (activity as MainActivity).viewModel1

        viewModel.displayAllCrops().observe(viewLifecycleOwner){

            adapter.differ.submitList(it)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}
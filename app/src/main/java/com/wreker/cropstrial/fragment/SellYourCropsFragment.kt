package com.wreker.cropstrial.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.wreker.cropstrial.MainActivity
import com.wreker.cropstrial.R
import com.wreker.cropstrial.databinding.FragmentSellYourCropsBinding
import com.wreker.cropstrial.model.Crops
import com.wreker.cropstrial.viewModel.MyViewModel


class SellYourCropsFragment : Fragment(R.layout.fragment_sell_your_crops) {

    private var _binding : FragmentSellYourCropsBinding?=null
    private val binding get() = _binding!!

    private lateinit var viewModel : MyViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSellYourCropsBinding.bind(view)

        viewModel = (activity as MainActivity).viewModel1

        binding.btnAddCrop.setOnClickListener {

            val crop = Crops(
                cropDetails = binding.cropDetails.text.toString(),
                price = Integer.parseInt(binding.cropPrice.text.toString()),
                sellerName = "Random Guy",
                cropType = binding.cropType.text.toString(),
                cropLocation = binding.cropLocation.text.toString(),
                cropSeason = binding.cropSeason.text.toString(),
                cropName = binding.cropName.text.toString(),
                0
            )

            viewModel.addCrop(crop)

            findNavController().navigate(R.id.action_sellYourCropsFragment_to_profileFragment)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
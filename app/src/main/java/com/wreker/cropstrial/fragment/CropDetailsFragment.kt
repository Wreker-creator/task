package com.wreker.cropstrial.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.wreker.cropstrial.R
import com.wreker.cropstrial.databinding.FragmentCropDetailsBinding


class CropDetailsFragment : Fragment(R.layout.fragment_crop_details) {

    private var _binding : FragmentCropDetailsBinding?=null
    private val args : CropDetailsFragmentArgs by navArgs()
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCropDetailsBinding.bind(view)

        binding.apply {

            ttvCropName.text = args.crop.cropName + " (${args.crop.sellerName}) " + args.crop.price + "Rs/Kg"
            ttvCropDetails.text = args.crop.cropDetails.toString()
            seasonDetails.text = args.crop.cropSeason
            locationDetails.text = args.crop.cropLocation

        }

        binding.btnBuy.setOnClickListener {
            findNavController().navigate(R.id.action_cropDetailsFragment_to_allCropsFragment)
            Toast.makeText(activity, "Bought 1kg of ${args.crop.cropName} at ${args.crop.price} Rs/Kg", Toast.LENGTH_LONG).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
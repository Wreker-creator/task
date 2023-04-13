package com.wreker.cropstrial.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wreker.cropstrial.model.Crops
import com.wreker.cropstrial.repository.Repository
import kotlinx.coroutines.launch

class MyViewModel(
    private val repository: Repository
) : ViewModel(){

    fun addCrop(crops : Crops) = viewModelScope.launch {
        repository.addCrops(crops)
    }

    fun displayAllCrops() = repository.getAllCrops()

    fun displaySelectedCrops() = repository.getSelectedCrops()

}
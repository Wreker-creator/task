package com.wreker.cropstrial.repository

import com.wreker.cropstrial.database.Dao
import com.wreker.cropstrial.database.Database
import com.wreker.cropstrial.model.Crops

class Repository(private val db : Database) {

    suspend fun addCrops(crops: Crops) = db.getCropsDao().addCrops(crops)

    suspend fun removeCrops(crops : Crops) = db.getCropsDao().deleteCrops(crops)

    fun getAllCrops() = db.getCropsDao().getAllCrops()

    fun getSelectedCrops() = db.getCropsDao().getSelectedCrops()


}
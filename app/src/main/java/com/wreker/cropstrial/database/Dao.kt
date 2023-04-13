package com.wreker.cropstrial.database

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wreker.cropstrial.model.Crops

@androidx.room.Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCrops(crop : Crops) : Long

    @Query("SELECT * FROM Crops ORDER BY id DESC")
    fun getAllCrops() : LiveData<List<Crops>>

    @Delete
    suspend fun deleteCrops(crop: Crops)

    @Query("SELECT * FROM Crops WHERE sellerName = 'Random Guy'")
    fun getSelectedCrops() : LiveData<List<Crops>>

}
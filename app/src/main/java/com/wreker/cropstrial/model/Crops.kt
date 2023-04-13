package com.wreker.cropstrial.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Crops")
data class Crops(
    val cropDetails: String,
    val price: Int,
    val sellerName: String,
    val cropType: String,
    val cropLocation: String,
    val cropSeason: String,
    val cropName: String,
    @PrimaryKey(autoGenerate = true)
    val id : Int
) : java.io.Serializable
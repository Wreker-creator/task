package com.wreker.cropstrial.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wreker.cropstrial.model.Crops

@androidx.room.Database(entities = [Crops::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase(){

    abstract fun getCropsDao() : Dao

    companion object{

        @Volatile
        private var INSTANCE : Database?=null

        fun getDatabase(context : Context) : Database{

            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }

            //we create a synchronous block here so that whatever happens
            //cannot be accessed by other threads

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Database::class.java,
                    "user-database"
                ).createFromAsset("database/crops.db").fallbackToDestructiveMigration().build()

                INSTANCE = instance
                return instance

            }

        }

    }

}
package com.example.compminventario.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.compminventario.data.dao.ProductDao
import com.example.compminventario.data.entities.Product

@Database(entities = [Product :: class], version = 1, exportSchema = false)
abstract class InventarioDatabase : RoomDatabase(){

    abstract fun productDao() : ProductDao

    companion object{
        @Volatile
        private var INSTANCE : InventarioDatabase? = null

        fun getDatabase(context: Context): InventarioDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InventarioDatabase::class.java,
                    "InventarioDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
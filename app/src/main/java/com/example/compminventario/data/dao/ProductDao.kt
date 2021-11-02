package com.example.compminventario.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.compminventario.data.entities.Product

interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addProduct(product: Product)

    @Update
    fun updateProduct(product: Product)

    @Query("SELECT * FROM product ORDER BY id DESC")
    fun readAllProducts(): LiveData<List<Product>>

    @Delete
    fun deleteProduct(product: Product)
}
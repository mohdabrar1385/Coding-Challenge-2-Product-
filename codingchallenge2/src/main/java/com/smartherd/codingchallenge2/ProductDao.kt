package com.smartherd.codingchallenge2

import androidx.lifecycle.LiveData
import androidx.room.*

// This class is used to create
// function for database.
@Dao
interface ProductDao {

    // Insert function is used to
    // insert data in database.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(product: Product1)

    // Delete function is used to
    // delete data in database.
    @Delete
    fun delete(product: Product1)

    // getAllGroceryItems function is used to get
    // all the data of database.
    @Query("SELECT * FROM product_items")
    fun readAllData(): LiveData<List<Product1>>
}

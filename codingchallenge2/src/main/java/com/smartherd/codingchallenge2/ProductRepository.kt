package com.smartherd.codingchallenge2


class ProductRepository(private val db: ProductDatabase) {

    suspend fun insert(item: Product1) = db.productDao().insert(item)
    suspend fun delete(item: Product1) = db.productDao().delete(item)

    fun readAllData() = db.productDao().readAllData()
}

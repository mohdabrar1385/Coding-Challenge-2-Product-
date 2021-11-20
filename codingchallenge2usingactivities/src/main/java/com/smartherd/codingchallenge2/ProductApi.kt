package com.smartherd.codingchallenge2

import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("/products")
    suspend fun getProducts(): Response<List<Product>>
}
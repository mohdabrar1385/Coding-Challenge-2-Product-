package com.smartherd.codingchallenge2

import android.os.Parcelable


data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)
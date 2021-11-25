package com.smartherd.codingchallenge2

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rating(
    val count: Int,
    val rate: Double
) : Parcelable
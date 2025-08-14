package com.gd.resizableapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Crypto(
    val id: String,
    val name: String,
    val price: Double,
    val imageUrl: String,
    val description: String,
    val websiteLink: String
) : Parcelable
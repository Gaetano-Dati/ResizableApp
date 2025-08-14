package com.gd.resizableapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Represents a cryptocurrency with basic details.
 *
 * @property id Unique identifier (symbol or code).
 * @property name Human-readable name of the cryptocurrency.
 * @property price Current price in Euros.
 * @property imageUrl Link to an image/logo.
 * @property description Short description of the cryptocurrency.
 * @property websiteLink Link to the official website.
 */
@Parcelize
data class Crypto(
    val id: String,
    val name: String,
    val price: Double,
    val imageUrl: String,
    val description: String,
    val websiteLink: String
) : Parcelable
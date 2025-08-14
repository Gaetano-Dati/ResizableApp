package com.gd.resizableapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Represents a cryptocurrency with essential details.
 *
 * This data class is [Parcelable], allowing instances to be passed between
 * Android components (e.g., activities or fragments).
 *
 * @property id A unique identifier for the cryptocurrency (e.g., "btc").
 * @property name The human-readable name of the cryptocurrency (e.g., "Bitcoin").
 * @property price The current price of the cryptocurrency in euros.
 * @property imageUrl A URL pointing to an image or logo representing the cryptocurrency.
 * @property description A brief description of the cryptocurrency.
 * @property websiteLink The official website or homepage of the cryptocurrency.
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
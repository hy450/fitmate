package com.yhan.fitmate.datamodel

import com.google.gson.annotations.SerializedName

data class FoodConfig(
        @SerializedName("breakfast") val breakfast: Char? = null,
        @SerializedName("launch") val launch: Char? = null,
        @SerializedName("dinner") val dinner: Char? = null
)
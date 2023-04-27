package com.example.testapplication.model

import com.google.gson.annotations.SerializedName

data class DogFacts(
   @SerializedName("facts") val facts: List<String>?,
    val success : Boolean?
)
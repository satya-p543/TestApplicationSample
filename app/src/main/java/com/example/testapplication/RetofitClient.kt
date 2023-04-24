package com.example.testapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetofitClient {

    val basUurl = "https://dog-facts-api.herokuapp.com"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(basUurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}
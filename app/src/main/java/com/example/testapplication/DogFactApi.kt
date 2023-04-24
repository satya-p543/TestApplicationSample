package com.example.testapplication

import DogFacts
import retrofit2.Call
import retrofit2.http.GET

interface DogFactApi {
    @GET("/api/v1/resources/dogs?number=1")
    fun getDogFactsApi(): Call<List<DogFacts>>


}
package com.example.testapplication

import com.example.testapplication.model.DogFacts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/facts")
    suspend fun getDogFacts(@Query("number") number: Int): Response<DogFacts>

    /* companion object {
         private var retrofitService: ApiService? = null
         fun getInstance(): ApiService {

             if (retrofitService == null) {
                 val retrofit = Retrofit.Builder()
                     .baseUrl(baseUrl)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build()
                 retrofitService = retrofit.create(ApiService::class.java)
             }
             return retrofitService!!
         }
     }*/

}
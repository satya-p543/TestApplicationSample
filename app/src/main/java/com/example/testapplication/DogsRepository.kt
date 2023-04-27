package com.example.testapplication

import javax.inject.Inject

class DogsRepository @Inject constructor(private val retrofitService : ApiService) {
   suspend fun getDogFacts(number: Int) =retrofitService.getDogFacts(number)
}
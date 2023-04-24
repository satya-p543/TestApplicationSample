package com.example.testapplication.viewmodel

import DogFacts
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.DogFactApi
import com.example.testapplication.RetofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogFactsViewmodel : ViewModel() {
    private var dogListLiveData = MutableLiveData<List<DogFacts>>()
    val dogsApi = RetofitClient.getInstance().create(DogFactApi::class.java)

    fun getDogFactList() {


        dogsApi.getDogFactsApi().enqueue(object : Callback<List<DogFacts>> {

            override fun onResponse(
                call: Call<List<DogFacts>>,
                response: Response<List<DogFacts>>
            ) {
                dogListLiveData.value = response.body()
                Log.i("satya","res"+response.body()+" "+dogListLiveData.value)
            }

            override fun onFailure(call: Call<List<DogFacts>>, t: Throwable) {
                Log.i("satya","fail "+t.message)
            }

        })


    }

    fun observeDogsLivedata(): LiveData<List<DogFacts>> {
        return dogListLiveData
    }
}



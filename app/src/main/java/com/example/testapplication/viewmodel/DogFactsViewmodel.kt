package com.example.testapplication.viewmodel

import DogFacts
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.ApiService
import com.example.testapplication.RetofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogFactsViewmodel : ViewModel() {
    private val dogListLiveData = MutableLiveData<List<DogFacts>>()
    private val errorMessage = MutableLiveData<String>()


    fun getDogFactList() {
        RetofitClient.dogsApi().getDogFactsApi().enqueue(object : Callback<List<DogFacts>> {
            override fun onResponse(
                call: Call<List<DogFacts>>,
                response: Response<List<DogFacts>>
            ) {
                dogListLiveData.postValue( response.body())
                Log.i("satya","success"+response.body()+" "+dogListLiveData.value)
            }

            override fun onFailure(call: Call<List<DogFacts>>, t: Throwable) {
                errorMessage.postValue(t.message)
                Log.i("satya","fail "+t.message)
            }

        })
    }

    fun observeDogsLivedata(): LiveData<List<DogFacts>> {
        return dogListLiveData
    }
}



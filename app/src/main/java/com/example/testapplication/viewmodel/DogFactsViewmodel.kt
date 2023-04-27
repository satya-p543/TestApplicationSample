package com.example.testapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapplication.DogsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DogFactsViewmodel(private val repository: DogsRepository) : ViewModel() {
    private val dogListLiveData = MutableLiveData<List<String>>()
    private val errorMessage = MutableLiveData<String>()


    fun getDogFactList(number: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getDogFacts(number)
            if (response.isSuccessful && response.body()?.success!!) {
                dogListLiveData.postValue(response.body()?.facts)
                Log.i("satya", "success" + response.body() + " " + dogListLiveData.value)
            } else {
                errorMessage.postValue(response.message())
                Log.i("satya", "fail " + response.message())
            }
        }
    }

    fun observeDogsLivedata(): LiveData<List<String>> {
        return dogListLiveData
    }
}



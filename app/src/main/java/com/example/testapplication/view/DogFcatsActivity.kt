package com.example.testapplication.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testapplication.databinding.ActivityDogsFactsBinding
import com.example.testapplication.viewmodel.DogFactsViewmodel

class DogFcatsActivity  : AppCompatActivity() {
    private lateinit var binding : ActivityDogsFactsBinding
    private lateinit var dogFactsViewmodel: DogFactsViewmodel
    private lateinit var dogFcatsAdapter : DogFcatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogsFactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        dogFactsViewmodel = ViewModelProvider(this)[DogFactsViewmodel::class.java]
        dogFactsViewmodel.getDogFactList()
        dogFactsViewmodel.observeDogsLivedata().observe(this, Observer { dogList ->
            dogFcatsAdapter.setDogList(dogList)
        })

    }
    private fun prepareRecyclerView() {
        dogFcatsAdapter = DogFcatsAdapter()
        binding.rvDogs.apply {
            layoutManager = GridLayoutManager(applicationContext,2)
            dogFcatsAdapter = DogFcatsAdapter()
        }
    }

}
package com.example.testapplication.view


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testapplication.MainApplication
import com.example.testapplication.databinding.ActivityDogsFactsBinding
import com.example.testapplication.viewmodel.DogFactsViewModelFactory
import com.example.testapplication.viewmodel.DogFactsViewmodel
import kotlinx.android.synthetic.main.activity_dogs_facts.view.errorId
import kotlinx.android.synthetic.main.activity_dogs_facts.view.rv_dogs
import javax.inject.Inject


class DogFcatsActivity : AppCompatActivity() {

    @Inject
    private lateinit var dogViewmodelfactory: DogFactsViewModelFactory

    private lateinit var binding: ActivityDogsFactsBinding
    private lateinit var dogFactsViewmodel: DogFactsViewmodel
    private lateinit var dogFcatsAdapter: DogFcatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogsFactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as MainApplication).applicationComponent.inject(this)
        dogFactsViewmodel =
            ViewModelProvider(this, dogViewmodelfactory).get(
                DogFactsViewmodel::class.java
            )

        init()


    }

    fun init() {
        prepareRecyclerView()
        dogFactsViewmodel.getDogFactList(5)
        observeLiveData()
    }

    private fun observeLiveData() {
        dogFactsViewmodel.getDogFactList(5)
        dogFactsViewmodel.observeDogsLivedata().observe(this, Observer { facts ->
            if (facts != null) {
                dogFcatsAdapter.setDogList(facts)
            } else {
                binding.root.rv_dogs.visibility = View.GONE
                binding.root.errorId.visibility = View.VISIBLE
            }
        })
    }

    private fun prepareRecyclerView() {
        dogFcatsAdapter = DogFcatsAdapter()
        binding.rvDogs.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            dogFcatsAdapter = DogFcatsAdapter()
        }
    }

}
package com.example.testapplication.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.databinding.DogFactItemLayoutBinding

class DogFcatsAdapter : RecyclerView.Adapter<DogFcatsAdapter.DogFcatsAdapterViewholder>() {
    private var dogList = ArrayList<String>()
    fun setDogList(dogList: List<String>) {
        this.dogList = dogList as ArrayList<String>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogFcatsAdapterViewholder {
        return DogFcatsAdapterViewholder(
            DogFactItemLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }


    override fun getItemCount(): Int {
        return dogList.size
    }

    override fun onBindViewHolder(holder: DogFcatsAdapterViewholder, position: Int) {
        val dogFacts = dogList[position]
        holder.binding.dogfactTextview.text = dogFacts
        Log.i("satya", "msg " + holder.binding.root)
    }

    class DogFcatsAdapterViewholder(val binding: DogFactItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}
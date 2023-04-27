package com.example.testapplication.di

import com.example.testapplication.view.DogFcatsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(dogsActivity: DogFcatsActivity)
}
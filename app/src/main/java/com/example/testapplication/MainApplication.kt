package com.example.testapplication

import android.app.Application
import com.example.testapplication.di.ApplicationComponent
import com.example.testapplication.di.DaggerApplicationComponent


class MainApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent= DaggerApplicationComponent.builder().build()
    }
}
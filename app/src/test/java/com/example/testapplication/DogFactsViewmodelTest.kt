package com.example.testapplication

import DogFactsItem
import com.example.testapplication.viewmodel.DogFactsViewmodel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class DogFactsViewmodelTest {
    lateinit var viewmodel: DogFactsViewmodel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewmodel = DogFactsViewmodel()
        viewmodel.getDogFactList()
    }

    @Test
    fun getDogFactSuccessCaseTest() {
        val dooFacts = DogFactsItem("Dogs are animalas")
        val value = viewmodel.observeDogsLivedata().value
        assertEquals(dooFacts.fact, value)
    }


    @Test
    fun getDogFactFailCaseTest() {
        val dooFacts = DogFactsItem("")
        val value = viewmodel.observeDogsLivedata().value
        assertEquals(dooFacts.fact, value)
    }
}
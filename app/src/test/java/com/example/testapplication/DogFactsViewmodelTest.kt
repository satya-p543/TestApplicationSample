package com.example.testapplication

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

    @Mock
    lateinit var repository: DogsRepository

    @Mock
    lateinit var apiService: ApiService

    @Before
     fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = DogsRepository(apiService)
        viewmodel = DogFactsViewmodel(repository)
        viewmodel.getDogFactList(5)
    }

    @Test
    fun getDogFactSuccessCaseTest() {
        val dogFacts = "Dogs are animalas"
        val value = viewmodel.observeDogsLivedata().value?.get(1)
        assertEquals(dogFacts, value)
    }


    @Test
    fun getDogFactFailCaseTest() {
        val dogFacts:List<String> = emptyList()
        val value = viewmodel.observeDogsLivedata().value
        assertEquals(dogFacts, value)
    }
}
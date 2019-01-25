package com.tasks.example.countries.ui.fragments

import android.arch.lifecycle.*
import com.tasks.example.countries.api.CountriesResponse
import com.tasks.example.countries.repository.CountriesRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val countriesRepository: CountriesRepository) : ViewModel() {

    val countries: LiveData<List<CountriesResponse>> = countriesRepository.results()

    fun getListOfBorderingCountries(borders: List<String>?): ArrayList<String> {
        val borderingCountries = arrayListOf<String>()
        borders?.forEach { code ->
            countries.value?.forEach { response ->
                if (response.alpha3Code == code) borderingCountries.add(response.nativeName)
            }
        }
        return borderingCountries
    }

    fun stopResponse() {
        countriesRepository.stopPresenting()
    }

}
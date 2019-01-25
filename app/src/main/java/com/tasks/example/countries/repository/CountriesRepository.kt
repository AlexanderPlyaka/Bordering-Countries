package com.tasks.example.countries.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.tasks.example.countries.api.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository that handles User objects.
 */
@Singleton
class CountriesRepository @Inject constructor(
    private val countriesService: CountriesService
) {

    private val countryData: MediatorLiveData<List<CountriesResponse>> = MediatorLiveData()

    private var job: Job? = null

    fun results(): LiveData<List<CountriesResponse>> {
        job = GlobalScope.launch(Dispatchers.Main) {
            countryData.addSource(countriesService.getAllCountries()) { response ->
                when (response) {
                    is ApiSuccessResponse -> {
                        countryData.postValue(response.body)
                    }
                    is ApiEmptyResponse -> {
                    }
                    is ApiErrorResponse -> {
                        response.errorMessage
                    }
                }
            }
        }
        return countryData
    }

    fun stopPresenting() {
        job?.cancel()
    }
}
